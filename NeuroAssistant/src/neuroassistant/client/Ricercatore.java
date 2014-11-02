package neuroassistant.client;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.net.*;
import java.util.*;
import org.apache.soap.rpc.*;
import org.apache.soap.encoding.SOAPMappingRegistry;
import org.apache.soap.*;
import org.apache.soap.encoding.soapenc.StringDeserializer;
import org.apache.soap.util.xml.QName;
import java.awt.event.*;





/**Classe che rappresenta l'interfaccia per Ricercatore,da dove può aggiungere nuove Malattie nel database.
 *
 * @author Abdul Rasheed Tutakhail
 */
public class Ricercatore extends javax.swing.JFrame {

    private static class EmptyLineException {

        public EmptyLineException(String string) {



        }
    }

    int sexint=0;
    String[] sexarra;
    String sexone;
    String sextwo;
    String description;
    int age;
    String agestr;
    String disease;
    String msg;
    String etastr;

    //SelectedEthnicities contiene il testo dei Checkbox dell'etnia scelti.
    List<String> selectedEthnicities = new ArrayList();
    JCheckBox[] ethnicities = new JCheckBox[5];
    String[] selec;
    //SelectedSintomi contiene il testo dei Checkbox dei sintomi scelti.
    List<String> selectedSintomi = new ArrayList();
    JCheckBox[] sintomi = new JCheckBox[10];
    String[] sintom;




    /** Creates new form Ricercatore */
    public Ricercatore() {
        initComponents();
        

    }
     private class EthnicityItemListener implements ItemListener {
        ArrayList selectedList;
        private EthnicityItemListener(ArrayList<String> selectedEthnicities) {
            this.selectedList = selectedEthnicities;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            //Aggiungi o rimuovi il testo dei Checkbox secondo
            //Stato di Selezione
            if(e.getStateChange() == ItemEvent.SELECTED){
                this.selectedList.add(((JCheckBox)e.getSource()).getText());
            }else {
                this.selectedList.remove(((JCheckBox)e.getSource()).getText());
            }
            System.out.println(selectedList);
        }
    }


  private class SintomiItemListener implements ItemListener {
        ArrayList selectedSintomlist;
        private SintomiItemListener(ArrayList<String> selectedSintomi) {
            this.selectedSintomlist = selectedSintomi;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            //Aggiungi o rimuovi il testo dei Checkbox secondo
            //Stato di Selezione
            if(e.getStateChange() == ItemEvent.SELECTED){
                this.selectedSintomlist.add(((JCheckBox)e.getSource()).getText());
            }else {
                this.selectedSintomlist.remove(((JCheckBox)e.getSource()).getText());
            }
            System.out.println(selectedSintomlist);
        }
    }








    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        malattia = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        agitazione = new javax.swing.JCheckBox();
        pocoEquilibrio = new javax.swing.JCheckBox();
        malDiTesta = new javax.swing.JCheckBox();
        schizofrenia = new javax.swing.JCheckBox();
        stress = new javax.swing.JCheckBox();
        convulsioni = new javax.swing.JCheckBox();
        nausea = new javax.swing.JCheckBox();
        emicrania = new javax.swing.JCheckBox();
        vomito = new javax.swing.JCheckBox();
        cefalee = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descrizione = new javax.swing.JTextArea();
        nuovo = new javax.swing.JButton();
        salva = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        eta = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        sessopanel = new javax.swing.JPanel();
        maschio = new javax.swing.JCheckBox();
        femmina = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cooltext558026900.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Malattia");

        malattia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                malattiaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        agitazione.setText("Agitazione");
        agitazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agitazioneActionPerformed(evt);
            }
        });

        pocoEquilibrio.setText("Poco Equilibrio");
        pocoEquilibrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pocoEquilibrioActionPerformed(evt);
            }
        });

        malDiTesta.setText("Mal di Testa");
        malDiTesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                malDiTestaActionPerformed(evt);
            }
        });

        schizofrenia.setText("Schizofrenia");
        schizofrenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schizofreniaActionPerformed(evt);
            }
        });

        stress.setText("Stress");
        stress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stressActionPerformed(evt);
            }
        });

        convulsioni.setText("Convulsioni");
        convulsioni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convulsioniActionPerformed(evt);
            }
        });

        nausea.setText("Nausea");
        nausea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nauseaActionPerformed(evt);
            }
        });

        emicrania.setText("Emicrania");
        emicrania.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emicraniaActionPerformed(evt);
            }
        });

        vomito.setText("Vomito");
        vomito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vomitoActionPerformed(evt);
            }
        });

        cefalee.setText("Cefalee");
        cefalee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cefaleeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agitazione)
                    .addComponent(pocoEquilibrio)
                    .addComponent(malDiTesta)
                    .addComponent(schizofrenia)
                    .addComponent(stress))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cefalee)
                    .addComponent(vomito)
                    .addComponent(emicrania)
                    .addComponent(nausea)
                    .addComponent(convulsioni))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agitazione)
                    .addComponent(convulsioni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pocoEquilibrio)
                    .addComponent(nausea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(malDiTesta)
                    .addComponent(emicrania))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(schizofrenia)
                    .addComponent(vomito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stress)
                    .addComponent(cefalee))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Descrizione");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Sintomi");

        descrizione.setColumns(20);
        descrizione.setRows(5);
        jScrollPane1.setViewportView(descrizione);

        nuovo.setText("          NUOVO");
        nuovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
        nuovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuovoActionPerformed(evt);
            }
        });

        salva.setText("          SALVA");
        salva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salva.png"))); // NOI18N
        salva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("Etnia");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText("Età");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText("Sesso");

        sessopanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        maschio.setText("Maschio");
        maschio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maschioActionPerformed(evt);
            }
        });

        femmina.setText("Femmina");
        femmina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femminaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sessopanelLayout = new javax.swing.GroupLayout(sessopanel);
        sessopanel.setLayout(sessopanelLayout);
        sessopanelLayout.setHorizontalGroup(
            sessopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sessopanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sessopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(femmina)
                    .addComponent(maschio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sessopanelLayout.setVerticalGroup(
            sessopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sessopanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(femmina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maschio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 71, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(157, 157, 157)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(sessopanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(eta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(jLabel2)))
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(salva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nuovo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(219, 219, 219))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(536, 536, 536)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(501, 501, 501)
                        .addComponent(malattia, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(nuovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salva))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(malattia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sessopanel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(3, 3, 3)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuovoActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Ricercatore().setVisible(true);
}//GEN-LAST:event_nuovoActionPerformed

    private void salvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvaActionPerformed
        // TODO add your handling code here:
       disease=malattia.getText();
       etastr=eta.getText();
       try{
       age=java.lang.Integer.parseInt(etastr);
       description=descrizione.getText();

         sexarra=new String[sexint];
        if(sexint==1)
        sexarra[0]=sexone;
        else{
            sexarra[0]=sexone;
            sexarra[1]=sextwo;}

   


             try{

                selec=new String[selectedEthnicities.size()];
                selectedEthnicities.toArray(selec);


                sintom=new String[selectedSintomi.size()];
                selectedSintomi.toArray(sintom);
                agestr=eta.getText();


                if(selec.length==0 || sintom.length==0 || sexarra.length==0){
                throw new EmptyStackException();
                }



                            try {
                                  URL url = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                                  //costruzione della chiamata
                                  Call chiamata = new Call();
                                  chiamata.setTargetObjectURI("urn:ServerNeuro");
                                  chiamata.setMethodName("aggiungi_malattia");
                                  chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);

                                   SOAPMappingRegistry smr = new SOAPMappingRegistry();
                                   StringDeserializer sd = new StringDeserializer ();
                                   smr.mapTypes (Constants.NS_URI_SOAP_ENC, new QName ("", "return"), null, null, sd);
                                   chiamata.setSOAPMappingRegistry(smr);


                                    //creazione dei parametri

                                    Vector parametri = new Vector();
                                    parametri.addElement(new Parameter("malattia", String.class, disease, null));
                                    parametri.addElement(new Parameter("age", int.class, age, null));
                                    parametri.addElement(new Parameter("descrizione", String.class, description, null));
                                    parametri.addElement(new Parameter("sexarra",String[].class, sexarra, null));
                                    parametri.addElement(new Parameter("selec",String[].class, selec, null));
                                    parametri.addElement(new Parameter("sintom",String[].class, sintom, null));

                                     chiamata.setParams(parametri);
                                     try {
                                              Response risp = chiamata.invoke(url, "");
                                              Parameter par = risp.getReturnValue();
                                              msg = (String) par.getValue();
                                              System.out.print(msg);
                                        
                                  }
                                     catch (SOAPException e) {
                                        System.out.println("Errore causata da: (" + e.getFaultCode() + ") :" + e.getMessage());
                                        msg = "errore";
                                  }

                            }
                            catch (MalformedURLException ex) {
                                  System.out.println("Exception: " + ex.getMessage());
                                     }

                             if (msg.equals("si")) {
                                        JOptionPane.showMessageDialog(null, "La registrazione è avvenuta con successo", "REGISTRAZIONE", JOptionPane.INFORMATION_MESSAGE);

                                  }

                            else if(msg.equals("error-connessione")) {
                              JOptionPane.showMessageDialog(this, "La connessione è fallita", "Errore", JOptionPane.ERROR_MESSAGE);
                                    }
                            else if(msg.equals("error-query")){
                              JOptionPane.showMessageDialog(this, "A disease with exact parameters might already exist, query failed", "Errore", JOptionPane.ERROR_MESSAGE);

                                  }

                             else{
                                  JOptionPane.showMessageDialog(null, "The disease might already exist", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
                                         }






                }
                 catch(EmptyStackException e){

                     JOptionPane.showMessageDialog(null, "Almeno un valore nei campi Sintomi, Etnia e Sesso deve essere scelto ", "Errore", JOptionPane.ERROR_MESSAGE);



                       }

        }
        catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null, "Solo valori numerici possono essere inseriti nel campo età e il campo non può essere lasciato vuoto ", "Errore", JOptionPane.ERROR_MESSAGE);

                }

    }//GEN-LAST:event_salvaActionPerformed

    private void femminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femminaActionPerformed
        // TODO add your handling code here:

        if(femmina.isSelected()){
            if(sexint==0){
              sexint++;
              sexone=femmina.getText();

            }

            else if(sexint==1){
                sexint++;
                sextwo=femmina.getText();
                     }
            else
                sexint--;
        
        


        }
    }//GEN-LAST:event_femminaActionPerformed

    private void maschioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maschioActionPerformed
        // TODO add your handling code here:
      

        if(maschio.isSelected()){
              if(sexint==0){
              sexint++;
              sexone=maschio.getText();

            }

            else if(sexint==1){
                sexint++;
                sextwo=maschio.getText();
            }
            else
                sexint--;
                


        }
    }//GEN-LAST:event_maschioActionPerformed

  

    

    private void malattiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_malattiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_malattiaActionPerformed

   

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentAdded

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Ricercatore.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Ricercatore.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Ricercatore.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Ricercatore.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Ricercatore().setVisible(true);
                


            }
        });
      }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox agitazione;
    private javax.swing.JCheckBox cefalee;
    private javax.swing.JCheckBox convulsioni;
    private javax.swing.JTextArea descrizione;
    private javax.swing.JCheckBox emicrania;
    private javax.swing.JFormattedTextField eta;
    private javax.swing.JCheckBox femmina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox malDiTesta;
    private javax.swing.JFormattedTextField malattia;
    private javax.swing.JCheckBox maschio;
    private javax.swing.JCheckBox nausea;
    private javax.swing.JButton nuovo;
    private javax.swing.JCheckBox pocoEquilibrio;
    private javax.swing.JButton salva;
    private javax.swing.JCheckBox schizofrenia;
    private javax.swing.JPanel sessopanel;
    private javax.swing.JCheckBox stress;
    private javax.swing.JCheckBox vomito;
    // End of variables declaration//GEN-END:variables


}