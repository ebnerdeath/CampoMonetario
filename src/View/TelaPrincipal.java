/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */package View;

import Validacao.CampoMonetario;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class TelaPrincipal extends javax.swing.JFrame {
BigDecimal valorEntradaBig = new BigDecimal(0);
BigDecimal valorTotalFixo;//ESSA VARIÁVEL É RESPONSÁVEL POR SEMPRE TER O VALOR TOTAL DA VENDA PARA SE PRECISAR ZERAR O DESCONTO, TEREMOS O VALOR TOTAL DA COMPRA PARA SETAR NA LABEL QUE MOSTRA O TOTAL DA VENDA
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        initCustom();
    }

    private void initCustom(){
        txtValorMonetario.setDocument(new CampoMonetario());
        txtValorMonetario.setText("R$ 0,0");
        btnLimpaCampos.requestFocus();
        valorTotalFixo = new BigDecimal(lblValorTotal1.getText().replace("R$","").replace(" ","").replace(".","").replace(",","."));//JOGAMOS NA VARIÁVEL VALORTOTAL O VALOR TOTAL DA VENDA QUE ESTÁ NA LABEL PARA FAZER O DECREMENTO DO VALOR DO DESCONTO   
    }
    
    public void EfetuaDesconto(){
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));//CRIAMOS UM FORMATO DE MOEDA PARA CONSEGUIR FORMATAR O NOSSO NÚMERO NO CAMPO
        CampoMonetario validacao = new CampoMonetario();//CRIAMOS UM OBJETO DA CLASSE CAMPO MONETARIO PARA VERIFICAR AS VIRGULAS E CASAS DECIMAIS DE NOSSO CAMPO
        String valormonetario = txtValorMonetario.getText().replace("R$","").replace("R","").replace("$","").replace(" ", "");//JOGAMOS NA VARIÁVEL VALORMONETARIO O VALOR DIGITADO FORMATANDO OS VALORES

        if(validacao.verificaVirgulas(valormonetario)==false){
            txtValorMonetario.setText("R$ 0,0");
            JOptionPane.showMessageDialog(null,"Valor Inválido!");
        }else{
            valorEntradaBig = new BigDecimal(valormonetario.replace(",","."));//SE NOSSA FUNÇÃO VERIFICOU A NOSSA STRING E RETORNOU TRUE, PEGAMOS E JOGAMOS O VALOR DA STRING EM UMA VARIÁVEL BIG DECIMAL CONVERTENDO VÍRGULA PARA PONTO
            BigDecimal valorTotalBig = new BigDecimal(lblValorTotal1.getText().replace("R$","").replace(" ","").replace(".","").replace(",","."));//JOGAMOS NA VARIÁVEL VALORTOTAL O VALOR TOTAL DA VENDA QUE ESTÁ NA LABEL PARA FAZER O DECREMENTO DO VALOR DO DESCONTO            
            txtValorMonetario.setText(nf.format(valorEntradaBig));
           
            if(valorEntradaBig.compareTo(valorTotalBig)==1){
                JOptionPane.showMessageDialog(null, "O Valor do desconto não pode ser maior que o valor total da venda!");
                txtValorMonetario.setText("R$ 0,0");
                valorEntradaBig = new BigDecimal(0);
            }else{
                valorTotalBig = valorTotalBig.subtract(valorEntradaBig);
                lblValorTotal1.setText(nf.format(valorTotalBig));
            }
        }
    }
    
    
    public void zeraDesconto(){
        BigDecimal valorTotalBig = new BigDecimal(lblValorTotal1.getText().replace("R$","").replace(" ","").replace(".","").replace(",","."));
        BigDecimal valorTotalCompra = valorTotalBig.add(valorEntradaBig);
        
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
        
        //valorTotalBig = valorTotalBig.add(valorTotalFixo);
        
        lblValorTotal1.setText(nf.format(valorTotalFixo));
        valorEntradaBig = new BigDecimal(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtValorMonetario = new javax.swing.JTextField();
        btnLimpaCampos = new javax.swing.JButton();
        lblValorTotal = new javax.swing.JLabel();
        lblValorTotal1 = new javax.swing.JLabel();
        btnEfetuarDesconto = new javax.swing.JButton();
        btnZerarDesconto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Descontos - JEBSoftware");
        setResizable(false);

        txtValorMonetario.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtValorMonetario.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.lightGray));
        txtValorMonetario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorMonetarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorMonetarioFocusLost(evt);
            }
        });

        btnLimpaCampos.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnLimpaCampos.setText("Limpa Campo");
        btnLimpaCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaCamposActionPerformed(evt);
            }
        });

        lblValorTotal.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblValorTotal.setText("Valor da Compra: ");

        lblValorTotal1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblValorTotal1.setText("R$ 1.500,00");

        btnEfetuarDesconto.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnEfetuarDesconto.setText("Efetuar Desconto");
        btnEfetuarDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfetuarDescontoActionPerformed(evt);
            }
        });

        btnZerarDesconto.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnZerarDesconto.setText("Zerar Desconto");
        btnZerarDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZerarDescontoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblValorTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorTotal1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(99, 99, 99)
                            .addComponent(txtValorMonetario, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(129, 129, 129)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnLimpaCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEfetuarDesconto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnZerarDesconto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorTotal)
                    .addComponent(lblValorTotal1))
                .addGap(56, 56, 56)
                .addComponent(txtValorMonetario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnEfetuarDesconto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnZerarDesconto)
                .addGap(8, 8, 8)
                .addComponent(btnLimpaCampos)
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpaCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaCamposActionPerformed
        txtValorMonetario.setText("R$ 0,0");
    }//GEN-LAST:event_btnLimpaCamposActionPerformed

    private void txtValorMonetarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorMonetarioFocusLost
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
        CampoMonetario validacao = new CampoMonetario();
        
        if(validacao.verificaVirgulas(txtValorMonetario.getText().replace("R$","").replace("R","").replace("$","").replace(" ", ""))==true){
            BigDecimal valorEntrada = new BigDecimal(txtValorMonetario.getText().replace("R$","").replace(" ","").replace("R","").replace("$","").replace(",","."));
            txtValorMonetario.setText(nf.format(valorEntrada));
        }else{
            txtValorMonetario.setText("R$ 0,0");
        }
    }//GEN-LAST:event_txtValorMonetarioFocusLost

    private void txtValorMonetarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorMonetarioFocusGained
        txtValorMonetario.setText("");
        zeraDesconto();
    }//GEN-LAST:event_txtValorMonetarioFocusGained

    private void btnEfetuarDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfetuarDescontoActionPerformed
        EfetuaDesconto();
    }//GEN-LAST:event_btnEfetuarDescontoActionPerformed

    private void btnZerarDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZerarDescontoActionPerformed
        zeraDesconto();
    }//GEN-LAST:event_btnZerarDescontoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEfetuarDesconto;
    private javax.swing.JButton btnLimpaCampos;
    private javax.swing.JButton btnZerarDesconto;
    private javax.swing.JLabel lblValorTotal;
    static javax.swing.JLabel lblValorTotal1;
    private javax.swing.JTextField txtValorMonetario;
    // End of variables declaration//GEN-END:variables
}
