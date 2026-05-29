package gym.form;

import gym.report.LaporanMember;
import gym.report.LaporanRekapJadwal;
import gym.report.LaporanTrainer;
import gym.report.LaporanTransaksiMembership;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class FormMenuUtama extends javax.swing.JFrame {

    private String namaAdmin;

    public FormMenuUtama() {
        this("Admin");
    }

    public FormMenuUtama(String namaAdmin) {
        this.namaAdmin = namaAdmin;
        initComponents();
        lblUser.setText("Login: " + namaAdmin + "  ");
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new gym.komponen.PanelGradient();
        lblHeader = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        statusPanel = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        lblVersion = new javax.swing.JLabel();
        desktopPane = new gym.komponen.DesktopPaneGym();
        menuBar = new javax.swing.JMenuBar();
        menuMaster = new javax.swing.JMenu();
        miMember = new javax.swing.JMenuItem();
        miTrainer = new javax.swing.JMenuItem();
        miPaket = new javax.swing.JMenuItem();
        miKelas = new javax.swing.JMenuItem();
        menuTransaksi = new javax.swing.JMenu();
        miPendaftaran = new javax.swing.JMenuItem();
        miJadwal = new javax.swing.JMenuItem();
        miBilling = new javax.swing.JMenuItem();
        menuReport = new javax.swing.JMenu();
        miLapMember = new javax.swing.JMenuItem();
        miLapTrainer = new javax.swing.JMenuItem();
        miLapTransaksi = new javax.swing.JMenuItem();
        miLapJadwal = new javax.swing.JMenuItem();
        menuKeluar = new javax.swing.JMenu();
        miLogout = new javax.swing.JMenuItem();
        miExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gym Me - Fitness Center Management");
        getContentPane().setLayout(new java.awt.BorderLayout());

        headerPanel.setPreferredSize(new java.awt.Dimension(0, 50));
        headerPanel.setLayout(new java.awt.BorderLayout());

        lblHeader.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblHeader.setText("    GYM ME - FITNESS CENTER MANAGEMENT");
        headerPanel.add(lblHeader, java.awt.BorderLayout.WEST);

        lblUser.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblUser.setForeground(new java.awt.Color(189, 195, 199));
        lblUser.setText("Login: Admin  ");
        headerPanel.add(lblUser, java.awt.BorderLayout.EAST);

        getContentPane().add(headerPanel, java.awt.BorderLayout.NORTH);

        statusPanel.setBackground(new java.awt.Color(52, 73, 94));
        statusPanel.setPreferredSize(new java.awt.Dimension(0, 28));
        statusPanel.setLayout(new java.awt.BorderLayout());

        lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 11));
        lblStatus.setForeground(new java.awt.Color(149, 165, 166));
        lblStatus.setText("   Siap");
        statusPanel.add(lblStatus, java.awt.BorderLayout.WEST);

        lblVersion.setFont(new java.awt.Font("Segoe UI", 0, 11));
        lblVersion.setForeground(new java.awt.Color(149, 165, 166));
        lblVersion.setText("Gym Me v1.0.0   ");
        statusPanel.add(lblVersion, java.awt.BorderLayout.EAST);

        getContentPane().add(statusPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        menuMaster.setFont(new java.awt.Font("Segoe UI", 1, 13));
        menuMaster.setText("  Master Data  ");

        miMember.setFont(new java.awt.Font("Segoe UI", 0, 13));
        miMember.setText("  Data Member");
        miMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMemberActionPerformed(evt);
            }
        });
        menuMaster.add(miMember);

        miTrainer.setFont(new java.awt.Font("Segoe UI", 0, 13));
        miTrainer.setText("  Data Personal Trainer");
        miTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTrainerActionPerformed(evt);
            }
        });
        menuMaster.add(miTrainer);

        miPaket.setFont(new java.awt.Font("Segoe UI", 0, 13));
        miPaket.setText("  Paket Membership");
        miPaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPaketActionPerformed(evt);
            }
        });
        menuMaster.add(miPaket);

        miKelas.setFont(new java.awt.Font("Segoe UI", 0, 13));
        miKelas.setText("  Data Kelas");
        miKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKelasActionPerformed(evt);
            }
        });
        menuMaster.add(miKelas);

        menuBar.add(menuMaster);

        menuTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 13));
        menuTransaksi.setText("  Transaksi  ");

        miPendaftaran.setFont(new java.awt.Font("Segoe UI", 0, 13));
        miPendaftaran.setText("  Pendaftaran Membership");
        miPendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPendaftaranActionPerformed(evt);
            }
        });
        menuTransaksi.add(miPendaftaran);

        miJadwal.setFont(new java.awt.Font("Segoe UI", 0, 13));
        miJadwal.setText("  Jadwal Kelas & Trainer");
        miJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miJadwalActionPerformed(evt);
            }
        });
        menuTransaksi.add(miJadwal);

        miBilling.setFont(new java.awt.Font("Segoe UI", 0, 13));
        miBilling.setText("  Billing / Pembayaran");
        miBilling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBillingActionPerformed(evt);
            }
        });
        menuTransaksi.add(miBilling);

        menuBar.add(menuTransaksi);

        menuReport.setFont(new java.awt.Font("Segoe UI", 1, 13));
        menuReport.setText("  Report  ");

        miLapMember.setFont(new java.awt.Font("Segoe UI", 0, 13));
        miLapMember.setText("  Laporan Data Member");
        miLapMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLapMemberActionPerformed(evt);
            }
        });
        menuReport.add(miLapMember);

        miLapTrainer.setFont(new java.awt.Font("Segoe UI", 0, 13));
        miLapTrainer.setText("  Laporan Kinerja Trainer");
        miLapTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLapTrainerActionPerformed(evt);
            }
        });
        menuReport.add(miLapTrainer);

        miLapTransaksi.setFont(new java.awt.Font("Segoe UI", 0, 13));
        miLapTransaksi.setText("  Laporan Transaksi Membership");
        miLapTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLapTransaksiActionPerformed(evt);
            }
        });
        menuReport.add(miLapTransaksi);

        miLapJadwal.setFont(new java.awt.Font("Segoe UI", 0, 13));
        miLapJadwal.setText("  Laporan Rekap Jadwal Harian");
        miLapJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLapJadwalActionPerformed(evt);
            }
        });
        menuReport.add(miLapJadwal);

        menuBar.add(menuReport);

        menuKeluar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        menuKeluar.setText("  Keluar  ");

        miLogout.setFont(new java.awt.Font("Segoe UI", 0, 13));
        miLogout.setText("  Logout");
        miLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLogoutActionPerformed(evt);
            }
        });
        menuKeluar.add(miLogout);

        miExit.setFont(new java.awt.Font("Segoe UI", 0, 13));
        miExit.setText("  Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        menuKeluar.add(miExit);

        menuBar.add(menuKeluar);

        setJMenuBar(menuBar);

        setSize(new java.awt.Dimension(1024, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMemberActionPerformed
        openForm(new FormMember());
    }//GEN-LAST:event_miMemberActionPerformed

    private void miTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTrainerActionPerformed
        openForm(new FormPersonalTrainer());
    }//GEN-LAST:event_miTrainerActionPerformed

    private void miPaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPaketActionPerformed
        openForm(new FormPaketMembership());
    }//GEN-LAST:event_miPaketActionPerformed

    private void miKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKelasActionPerformed
        openForm(new FormKelas());
    }//GEN-LAST:event_miKelasActionPerformed

    private void miPendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPendaftaranActionPerformed
        openForm(new FormPendaftaranMembership());
    }//GEN-LAST:event_miPendaftaranActionPerformed

    private void miJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miJadwalActionPerformed
        openForm(new FormJadwalKelas());
    }//GEN-LAST:event_miJadwalActionPerformed

    private void miBillingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBillingActionPerformed
        openForm(new FormBilling());
    }//GEN-LAST:event_miBillingActionPerformed

    private void miLapMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLapMemberActionPerformed
        LaporanMember laporan = new LaporanMember();
        laporan.setVisible(true);
    }//GEN-LAST:event_miLapMemberActionPerformed

    private void miLapTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLapTrainerActionPerformed
        LaporanTrainer laporan = new LaporanTrainer();
        laporan.setVisible(true);
    }//GEN-LAST:event_miLapTrainerActionPerformed

    private void miLapTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLapTransaksiActionPerformed
        LaporanTransaksiMembership laporan = new LaporanTransaksiMembership();
        laporan.setVisible(true);
    }//GEN-LAST:event_miLapTransaksiActionPerformed

    private void miLapJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLapJadwalActionPerformed
        LaporanRekapJadwal laporan = new LaporanRekapJadwal();
        laporan.setVisible(true);
    }//GEN-LAST:event_miLapJadwalActionPerformed

    private void miLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLogoutActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin logout?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
            new FormLogin().setVisible(true);
        }
    }//GEN-LAST:event_miLogoutActionPerformed

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_miExitActionPerformed

    private void openForm(JInternalFrame form) {
        desktopPane.add(form);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle screen = ge.getMaximumWindowBounds();
        int areaWidth = screen.width;
        int areaHeight = screen.height - 120;
        int x = (areaWidth - form.getWidth()) / 2;
        int y = (areaHeight - form.getHeight()) / 2;
        if (x < 0) x = 0;
        if (y < 0) y = 0;
        form.setLocation(x, y);
        form.setVisible(true);
        try { form.setSelected(true); } catch (Exception ex) {}
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gym.komponen.DesktopPaneGym desktopPane;
    private gym.komponen.PanelGradient headerPanel;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuKeluar;
    private javax.swing.JMenu menuMaster;
    private javax.swing.JMenu menuReport;
    private javax.swing.JMenu menuTransaksi;
    private javax.swing.JMenuItem miBilling;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miJadwal;
    private javax.swing.JMenuItem miKelas;
    private javax.swing.JMenuItem miLapJadwal;
    private javax.swing.JMenuItem miLapMember;
    private javax.swing.JMenuItem miLapTrainer;
    private javax.swing.JMenuItem miLapTransaksi;
    private javax.swing.JMenuItem miLogout;
    private javax.swing.JMenuItem miMember;
    private javax.swing.JMenuItem miPaket;
    private javax.swing.JMenuItem miPendaftaran;
    private javax.swing.JMenuItem miTrainer;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables
}
