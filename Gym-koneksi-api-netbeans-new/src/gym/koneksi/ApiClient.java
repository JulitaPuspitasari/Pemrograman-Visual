package gym.koneksi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ApiClient {

    public static final String BASE_URL = "https://api-perpustakaan.tofla.id/api/gym";

    static {
        // Paksa TLS 1.2 untuk JDK 8 versi lama (default-nya TLS 1.0)
        System.setProperty("https.protocols", "TLSv1.2");
        System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
    }

    public static class ApiResponse {
        public final int status;
        public final String body;
        public ApiResponse(int status, String body) {
            this.status = status;
            this.body = body;
        }
        public boolean ok() { return status >= 200 && status < 300; }
    }

    public static ApiResponse get(String path) throws IOException {
        return request("GET", path, null);
    }

    public static ApiResponse post(String path, String jsonBody) throws IOException {
        return request("POST", path, jsonBody);
    }

    public static ApiResponse put(String path, String jsonBody) throws IOException {
        return request("PUT", path, jsonBody);
    }

    public static ApiResponse delete(String path) throws IOException {
        return request("DELETE", path, null);
    }

    private static ApiResponse request(String method, String path, String body) throws IOException {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(BASE_URL + path);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            conn.setConnectTimeout(8000);
            conn.setReadTimeout(15000);
            if (body != null) {
                conn.setDoOutput(true);
                OutputStream os = conn.getOutputStream();
                os.write(body.getBytes("UTF-8"));
                os.flush();
                os.close();
            }
            int status = conn.getResponseCode();
            InputStream in = (status >= 200 && status < 300)
                    ? conn.getInputStream() : conn.getErrorStream();
            StringBuilder sb = new StringBuilder();
            if (in != null) {
                BufferedReader r = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                String line;
                while ((line = r.readLine()) != null) sb.append(line);
                r.close();
            }
            return new ApiResponse(status, sb.toString());
        } finally {
            if (conn != null) conn.disconnect();
        }
    }

    public static String encodePath(String s) {
        try { return URLEncoder.encode(s, "UTF-8").replace("+", "%20"); }
        catch (Exception e) { return s; }
    }

    public static String buildJson(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        for (Map.Entry<String, Object> e : map.entrySet()) {
            if (!first) sb.append(",");
            first = false;
            sb.append("\"").append(escape(e.getKey())).append("\":");
            Object v = e.getValue();
            if (v == null) {
                sb.append("null");
            } else if (v instanceof Number || v instanceof Boolean) {
                sb.append(v.toString());
            } else {
                sb.append("\"").append(escape(v.toString())).append("\"");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private static String escape(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '"': sb.append("\\\""); break;
                case '\\': sb.append("\\\\"); break;
                case '\n': sb.append("\\n"); break;
                case '\r': sb.append("\\r"); break;
                case '\t': sb.append("\\t"); break;
                default:
                    if (c < 0x20) sb.append(String.format("\\u%04x", (int) c));
                    else sb.append(c);
            }
        }
        return sb.toString();
    }

    public static List<Map<String, String>> parseDataArray(String json) {
        List<Map<String, String>> rows = new ArrayList<>();
        if (json == null) return rows;
        int dataIdx = json.indexOf("\"data\"");
        int start;
        if (dataIdx >= 0) {
            start = json.indexOf('[', dataIdx);
        } else {
            start = json.indexOf('[');
        }
        if (start < 0) return rows;
        int depth = 0;
        int objStart = -1;
        for (int i = start; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '{') {
                if (depth == 0) objStart = i;
                depth++;
            } else if (c == '}') {
                depth--;
                if (depth == 0 && objStart >= 0) {
                    rows.add(parseObject(json.substring(objStart, i + 1)));
                    objStart = -1;
                }
            } else if (c == ']' && depth == 0) {
                break;
            }
        }
        return rows;
    }

    public static Map<String, String> parseObject(String json) {
        Map<String, String> map = new LinkedHashMap<>();
        if (json == null) return map;
        int i = 0;
        int len = json.length();
        while (i < len) {
            int keyStart = json.indexOf('"', i);
            if (keyStart < 0) break;
            int keyEnd = findStringEnd(json, keyStart);
            if (keyEnd < 0) break;
            String key = unescape(json.substring(keyStart + 1, keyEnd));
            int colon = json.indexOf(':', keyEnd);
            if (colon < 0) break;
            int j = colon + 1;
            while (j < len && Character.isWhitespace(json.charAt(j))) j++;
            if (j >= len) break;
            char c = json.charAt(j);
            String value;
            if (c == '"') {
                int strEnd = findStringEnd(json, j);
                if (strEnd < 0) break;
                value = unescape(json.substring(j + 1, strEnd));
                i = strEnd + 1;
            } else if (c == '{' || c == '[') {
                int end = findBracketEnd(json, j);
                if (end < 0) break;
                value = json.substring(j, end + 1);
                i = end + 1;
            } else {
                int end = j;
                while (end < len && ",}]".indexOf(json.charAt(end)) < 0) end++;
                value = json.substring(j, end).trim();
                if (value.equals("null")) value = "";
                i = end;
            }
            map.put(key, value);
        }
        return map;
    }

    private static int findStringEnd(String s, int start) {
        for (int i = start + 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\\') { i++; continue; }
            if (c == '"') return i;
        }
        return -1;
    }

    private static int findBracketEnd(String s, int start) {
        char open = s.charAt(start);
        char close = (open == '{') ? '}' : ']';
        int depth = 0;
        boolean inStr = false;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (inStr) {
                if (c == '\\') { i++; continue; }
                if (c == '"') inStr = false;
                continue;
            }
            if (c == '"') inStr = true;
            else if (c == open) depth++;
            else if (c == close) {
                depth--;
                if (depth == 0) return i;
            }
        }
        return -1;
    }

    private static String unescape(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\\' && i + 1 < s.length()) {
                char n = s.charAt(++i);
                switch (n) {
                    case '"': sb.append('"'); break;
                    case '\\': sb.append('\\'); break;
                    case '/': sb.append('/'); break;
                    case 'n': sb.append('\n'); break;
                    case 'r': sb.append('\r'); break;
                    case 't': sb.append('\t'); break;
                    case 'b': sb.append('\b'); break;
                    case 'f': sb.append('\f'); break;
                    case 'u':
                        if (i + 4 < s.length()) {
                            sb.append((char) Integer.parseInt(s.substring(i + 1, i + 5), 16));
                            i += 4;
                        }
                        break;
                    default: sb.append(n);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static boolean isSuccess(String json) {
        return json != null && json.contains("\"success\":true");
    }

    public static String errorMessage(String json) {
        if (json == null) return "Tidak ada respons dari server";
        Map<String, String> m = parseObject(json);
        String err = m.get("error");
        if (err == null || err.isEmpty()) return "Terjadi kesalahan pada server";
        return err;
    }
}
