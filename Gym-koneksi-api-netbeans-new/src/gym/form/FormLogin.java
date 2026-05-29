package gym.form;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class FormLogin extends javax.swing.JFrame {

    public FormLogin() {
        initComponents();
        setupTambahan();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelKiri = new gym.komponen.PanelGradient();
        lblIcon = new javax.swing.JLabel();
        lblBrand1 = new javax.swing.JLabel();
        lblBrand2 = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        sepBrand = new javax.swing.JSeparator();
        lblFooter1 = new javax.swing.JLabel();
        lblFooter2 = new javax.swing.JLabel();
        panelKanan = new javax.swing.JPanel();
        cardLogin = new gym.komponen.PanelKartu();
        lblWelcome = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new gym.komponen.ButtonGradient();
        lblVersion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - Gym Me");
        setResizable(false);
        getContentPane().setLayout(null);

        panelKiri.setVertical(true);
        panelKiri.setLayout(null);

        lblIcon.setFont(new java.awt.Font("Arial", 1, 80)); // NOI18N
        lblIcon.setForeground(new java.awt.Color(255, 255, 255));
        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setText("♦");
        panelKiri.add(lblIcon);
        lblIcon.setBounds(0, 70, 400, 100);

        lblBrand1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblBrand1.setForeground(new java.awt.Color(255, 255, 255));
        lblBrand1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBrand1.setText("GYM ME");
        panelKiri.add(lblBrand1);
        lblBrand1.setBounds(0, 180, 400, 45);

        lblBrand2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBrand2.setForeground(new java.awt.Color(243, 156, 18));
        lblBrand2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBrand2.setText("FITNESS CENTER");
        panelKiri.add(lblBrand2);
        lblBrand2.setBounds(0, 230, 400, 25);

        lblDesc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblDesc.setForeground(new java.awt.Color(189, 195, 199));
        lblDesc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesc.setText("<html><center>Kelola member, trainer, kelas<br>dan membership dengan mudah<br>dan efisien</center></html>");
        panelKiri.add(lblDesc);
        lblDesc.setBounds(0, 270, 400, 60);

        sepBrand.setForeground(new java.awt.Color(255, 255, 255));
        panelKiri.add(sepBrand);
        sepBrand.setBounds(100, 350, 200, 2);

        lblFooter1.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        lblFooter1.setForeground(new java.awt.Color(149, 165, 166));
        lblFooter1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFooter1.setText("UAS Pemrograman Visual - Kelompok 2");
        panelKiri.add(lblFooter1);
        lblFooter1.setBounds(0, 370, 400, 18);

        lblFooter2.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        lblFooter2.setForeground(new java.awt.Color(149, 165, 166));
        lblFooter2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFooter2.setText("Universitas Indraprasta PGRI");
        panelKiri.add(lblFooter2);
        lblFooter2.setBounds(0, 390, 400, 18);

        getContentPane().add(panelKiri);
        panelKiri.setBounds(0, 0, 400, 500);

        panelKanan.setBackground(new java.awt.Color(248, 249, 250));
        panelKanan.setLayout(null);

        cardLogin.setLayout(null);

        lblWelcome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(44, 62, 80));
        lblWelcome.setText("Selamat Datang");
        cardLogin.add(lblWelcome);
        lblWelcome.setBounds(40, 25, 300, 35);

        lblSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubtitle.setForeground(new java.awt.Color(149, 165, 166));
        lblSubtitle.setText("Silakan login untuk melanjutkan");
        cardLogin.add(lblSubtitle);
        lblSubtitle.setBounds(40, 55, 300, 25);

        lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(127, 140, 141));
        lblUsername.setText("USERNAME");
        cardLogin.add(lblUsername);
        lblUsername.setBounds(40, 100, 300, 20);

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cardLogin.add(txtUsername);
        txtUsername.setBounds(40, 122, 300, 38);

        lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(127, 140, 141));
        lblPassword.setText("PASSWORD");
        cardLogin.add(lblPassword);
        lblPassword.setBounds(40, 175, 300, 20);

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cardLogin.add(txtPassword);
        txtPassword.setBounds(40, 197, 300, 38);

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setText("MASUK");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        cardLogin.add(btnLogin);
        btnLogin.setBounds(40, 260, 300, 42);

        lblVersion.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblVersion.setForeground(new java.awt.Color(189, 195, 199));
        lblVersion.setText("v1.0.0");
        cardLogin.add(lblVersion);
        lblVersion.setBounds(310, 320, 60, 20);

        panelKanan.add(cardLogin);
        cardLogin.setBounds(60, 65, 380, 360);

        getContentPane().add(panelKanan);
        panelKanan.setBounds(400, 0, 500, 500);

        setSize(new java.awt.Dimension(900, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void setupTambahan() {
        ImageIcon logoIcon = new ImageIcon("GymMe_Logo.png");
        if (logoIcon.getIconWidth() > 0) {
            lblIcon.setIcon(logoIcon);
            lblIcon.setText("");
            setIconImage(logoIcon.getImage());
        }
        txtPassword.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) login();
            }
        });
    }

    private void login() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username dan Password harus diisi!",
                "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        HttpURLConnection connection = null;
        try {
            URL url = new URL("https://api-perpustakaan.tofla.id/api/gym/login");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            connection.setDoOutput(true);

            String jsonBody = "{\"username\":\"" + username.replace("\"", "\\\"") + "\",\"password\":\"" + password.replace("\"", "\\\"") + "\"}";

            OutputStream os = connection.getOutputStream();
            os.write(jsonBody.getBytes("UTF-8"));
            os.flush();
            os.close();

            int status = connection.getResponseCode();
            BufferedReader reader;
            if (status >= 200 && status < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), "UTF-8"));
            }

            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();

            String response = responseBuilder.toString();
            boolean success = response.contains("\"success\":true");

            System.out.println("[FormLogin] Status: " + status);
            System.out.println("[FormLogin] Response: " + response);

            if (success) {
                String nama = extractJsonField(response, "nama");
                if (nama == null || nama.isEmpty()) {
                    String adminObject = extractJsonField(response, "admin");
                    if (adminObject != null) {
                        nama = extractJsonField(adminObject, "nama");
                    }
                    if (nama == null || nama.isEmpty()) {
                        nama = username;
                    }
                }
                JOptionPane.showMessageDialog(this,
                    "Login Berhasil!\nSelamat datang, " + nama,
                    "Sukses", JOptionPane.INFORMATION_MESSAGE);

                FormMenuUtama menu = new FormMenuUtama(nama);
                menu.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Login Gagal!\nStatus HTTP: " + status + "\nResponse: " + response,
                    "Login Gagal", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Gagal koneksi ke server API:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (connection != null) connection.disconnect();
        }
    }

    private String extractJsonField(String json, String field) {
        String pattern = "\"" + field + "\"";
        int index = json.indexOf(pattern);
        if (index == -1) return null;
        int colonIndex = json.indexOf(":", index + pattern.length());
        if (colonIndex == -1) return null;
        int startQuote = json.indexOf("\"", colonIndex + 1);
        if (startQuote == -1) return null;
        int endQuote = json.indexOf("\"", startQuote + 1);
        if (endQuote == -1) return null;
        return json.substring(startQuote + 1, endQuote);
    }

    public static void main(String args[]) {
        // Paksa TLS 1.2 untuk JDK 8 versi lama (default-nya TLS 1.0)
        System.setProperty("https.protocols", "TLSv1.2");
        System.setProperty("jdk.tls.client.protocols", "TLSv1.2");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gym.komponen.ButtonGradient btnLogin;
    private gym.komponen.PanelKartu cardLogin;
    private javax.swing.JLabel lblBrand1;
    private javax.swing.JLabel lblBrand2;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblFooter1;
    private javax.swing.JLabel lblFooter2;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel panelKanan;
    private gym.komponen.PanelGradient panelKiri;
    private javax.swing.JSeparator sepBrand;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
