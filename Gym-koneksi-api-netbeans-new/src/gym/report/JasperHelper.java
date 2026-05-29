package gym.report;

import java.awt.Window;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class JasperHelper {

    static {
        DefaultJasperReportsContext.getInstance().setProperty(
            "net.sf.jasperreports.compiler.class",
            "net.sf.jasperreports.compilers.JRGroovyCompiler");
        DefaultJasperReportsContext.getInstance().setProperty(
            "net.sf.jasperreports.compiler.groovy",
            "net.sf.jasperreports.compilers.JRGroovyCompiler");
    }

    public static void tampilkanLaporan(Window owner, String jrxmlResource, String judul,
                                        List<Map<String, ?>> data) {
        try {
            InputStream is = JasperHelper.class.getResourceAsStream(jrxmlResource);
            if (is == null) {
                JOptionPane.showMessageDialog(owner,
                    "Template laporan tidak ditemukan: " + jrxmlResource,
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JasperReport jasperReport = JasperCompileManager.compileReport(is);
            is.close();

            Map<String, Object> params = new HashMap<>();
            params.put("judul", judul);
            params.put("tanggalCetak", new SimpleDateFormat("dd MMMM yyyy HH:mm").format(new Date()));

            JRMapCollectionDataSource ds = new JRMapCollectionDataSource(data);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, ds);

            javax.swing.JDialog dialog = new javax.swing.JDialog(owner, judul, java.awt.Dialog.ModalityType.APPLICATION_MODAL);
            dialog.setSize(1100, 700);
            dialog.setLocationRelativeTo(owner);
            dialog.add(new JRViewer(jasperPrint));
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(owner,
                "Gagal menampilkan laporan:\n" + e.getMessage(),
                "Error Jasper", JOptionPane.ERROR_MESSAGE);
        }
    }
}
