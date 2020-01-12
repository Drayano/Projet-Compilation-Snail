
import java.io.BufferedReader;
import javax.swing.text.DefaultCaret;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Compilation extends javax.swing.JFrame {

    /**
     * Creates new form Compilation
     */
    public Compilation() {
        initComponents();
    }
    
    String chemin = "";
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static boolean isInt(String str) {
        
              try { 
              int myInt = Integer.parseInt(str); 
              return true;
              } 
              catch(NumberFormatException e) { 
              return false;
              }
    }
        
     public static boolean isAlpha(String name) 
     {
        char[] chars = name.toCharArray();
    
        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
    
        return true;
    }
        
    public static boolean isIdent (String str)
    {
        int i = 1,j = 0;
        boolean finish = false;

        if(isAlpha(Character.toString(str.charAt(0))))
        {
            
        if(!str.contains("_"))
        {
            return true;
        }

        if(str.charAt(str.length()-1)=='_')
        {
            return false;
        }

        while(i != str.length())
        {
            if(str.charAt(i) == '_'&&str.charAt(i+1)=='_')
            {
                return false;
            }
            i++;
        }

        return true;
        }

        return false;
    }

    private String identification(String id)
    {
        
        String mots_cle[] = {"Start_Program", "End_Program", ";;", "Int_Number", "Real_Number", "String", "Give", 
                             "Affect", ":", "If", "Else", "--", "Start", "Finish", "ShowMes", "ShowVal", "//.", 
                             "to", "\"", "<", ">", "=", "<=", ">=", "--"};
		
        for (int i = 0; i < mots_cle.length; i++)
        {
            if (id.equals(mots_cle[i]))
                switch(id)
                {
                    case "Start_Program" :
                        return id + " : Mot réservé début d'un programme";

                    case "End_Program" :
                        return id + " : Mot réservé fin d'un programme";

                    case ";;" :
                        return id + " : Mot réservé fin d'instruction";

                    case "Int_Number" :
                        return id + " : Mot réservé déclaration d'un entier";

                    case "Real_Number" :
                        return id + " : Mot réservé déclaration d'un réel";

                    case "String" :
                        return id + " : Mot réservé déclaration d'une chaine de caractère";

                    case "Give" :
                    case "Affect" :
                    case "Start" :
                    case "Finish" :
                    case "ShowMes" : 
                    case "ShowVal" : 
                    case "to" :
                        return id + " : Mot réservé";

                    case ":" :
                    case "\"" :
                        return id + " : Caractère réservé";

                    case "<" :
                        return id + " : Symbole inférieur";

                    case ">" :
                        return id + " : Symbole supérieur";

                    case "=" :
                        return id + " : Symbole égal";

                    case "<=" :
                        return id + " : Symbole inférieur ou égal";

                    case ">=" :
                        return id + " : Symbole supérieur ou égal";

                    case "If" :
                    case "Else" :
                    case "--" :
                        return id + " : Symbole de condition";

                    case "//." :
                        return id + " : Symbole de commentaire";
                }
        }
		

        if(isInt(id))
            return id + " est un Nombre Entier";

        if(isNumeric(id))
            return id + " est un Nombre Reel";
		
        if(isIdent(id))
            return id + " est un Identificateur";

        if(id.equals(","))
            return id + " est un caractère réservé";

        else
            return "Erreur : " + id;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        analyseSem = new javax.swing.JButton();
        analyseSynt = new javax.swing.JButton();
        save = new javax.swing.JButton();
        analyseLex = new javax.swing.JButton();
        changerFichier1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilation ");
        setResizable(false);

        jSplitPane1.setToolTipText("");
        jSplitPane1.setEnabled(false);

        jPanel3.setEnabled(false);

        analyseSem.setText("Analyse sémantique");
        analyseSem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyseSemActionPerformed(evt);
            }
        });

        analyseSynt.setText("Analyse syntaxique");
        analyseSynt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyseSyntActionPerformed(evt);
            }
        });

        save.setText("Réinitialiser");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        analyseLex.setText("Analyse lexicale");
        analyseLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyseLexActionPerformed(evt);
            }
        });

        changerFichier1.setText("Charger fichier");
        changerFichier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changerFichier1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(analyseSynt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(analyseSem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(analyseLex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(changerFichier1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(analyseSynt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(analyseSem, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(157, 157, 157)
                    .addComponent(analyseLex, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(320, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addComponent(changerFichier1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(394, Short.MAX_VALUE)))
        );

        jSplitPane1.setLeftComponent(jPanel3);

        jPanel4.setEnabled(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void analyseSemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyseSemActionPerformed
            if (jTextArea1.getText().equals("") || jTextArea1.getText().equals("Erreur : Veuillez choisir un fichier !"))
            {
                jTextArea1.setText("Erreur : Veuillez choisir un fichier !");
                return;
            }

            try
            {
                FileReader read = new FileReader(chemin);
                BufferedReader br = new BufferedReader(read);
                jTextArea1.read(br, null);
                br.close();
                //br = new BufferedReader(new FileReader("Code.compila"));
	            
                String sauvegarde = "";
                int compteur = 0;
                int nbElse = 0;
                int nbIf = 0;
                int nbStart = 0;
                int nbEnd = 0;
                
                List<String> mots = new ArrayList<String>();
                
                DefaultCaret caret = (DefaultCaret) jTextArea1.getCaret();
                caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

                String[] words;
                List<String> list = null;

                words = jTextArea1.getText().split("\n");

                list = Arrays.asList(words);

                for(int j = 0; j < list.size(); j++)
                    mots.add(list.get(j));

                FileWriter fileWriter = new FileWriter("Semantique.txt");
                
                sauvegarde = jTextArea1.getText();
                jTextArea1.setText("");
                for(String ligne:mots)
                {
                    if(!instruction(ligne))
                        compteur++;       
                        
                    if(ligne.equals("Else"))
                        nbElse++;

                    if(ligne.equals("If"))
                        nbIf++;
                }    
                for(String ligne:mots)
                {
                    if(!instruction(ligne))
                        compteur++;       
                        
                    if(ligne.equals("Start_Program"))
                        nbStart++;

                    if(ligne.equals("End_Program"))
                        nbEnd++;
                } 
                
                jTextArea1.setText(sauvegarde);
                if (compteur > 0 || !mots.get(0).equals("Start_Program") || !mots.get(mots.size() - 1).equals("End_Program") || nbElse > nbIf)
                {
                    if (!mots.get(0).equals("Start_Program"))
                        compteur++;               
                    
                    if (!mots.get(mots.size() - 1).equals("End_Program"))
                        //compteur++;    

                    if (nbElse != nbIf)
                        compteur++;
                    if(nbStart > 1 != nbEnd > 1)
                        compteur++;
                    
                    jTextArea1.append("\n\nCode non-valide, il y a " + compteur + " erreurs\n");
                }

                else
                {
                    jTextArea1.append("\n\nCode valide !\n");
                }

                fileWriter.write(jTextArea1.getText() + "\n");
                fileWriter.close();
                br.close();
            }
            
            catch (FileNotFoundException ex) 
            {
                Logger.getLogger(Compilation.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IOException ex) 
            {
                Logger.getLogger(Compilation.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_analyseSemActionPerformed

    private boolean instruction(String ligne)
    {
        String suivant = "";
        String intermediare = "";
        int compteur = 0;
        String[] words;
        List<String> id = new ArrayList<String>();
        List<String> list = null;
        
        words = ligne.split(" ");
        list = Arrays.asList(words);
        
        for(int j = 0; j < list.size(); j++)
            id.add(list.get(j));
        
        Iterator<String> it = list.iterator();
        Iterator<String> io = id.iterator();
        switch(list.get(0))
        {
            case "Give" :
                if (it.hasNext())
                { 
                    jTextArea1.append("Give ");
                    it.next();
                    suivant = it.next();
                    intermediare = suivant;
                    jTextArea1.append(suivant + " ");
                    if(identification(suivant).equals(suivant + " est un Identificateur"))
                    {
                        if (it.hasNext())
                        {
                            suivant = it.next();
                            jTextArea1.append(suivant + " ");
                            if(suivant.equals(":"))
                            {
                                if (it.hasNext())
                                {
                                    suivant = it.next();
                                    jTextArea1.append(suivant + " ");
                                    if(identification(suivant).equals(suivant + " est un Nombre Entier") || identification(suivant).equals(suivant + " est un Nombre Reel"))
                                    {
                                        if (it.hasNext())
                                        {
                                            suivant = it.next();
                                            jTextArea1.append(suivant + " ");
                                            if(suivant.equals(";;"))
                                            {
                                                jTextArea1.append(" - Affectation d'une valeur à " + intermediare + " reconnue\n");
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
                jTextArea1.append(" - Affectation non-valide\n");
                return false;
                
            case "Affect" :
                if (it.hasNext())
                {
                    jTextArea1.append("Affect ");
                    it.next();
                    suivant = it.next();
                    jTextArea1.append(suivant + " ");
                    if(identification(suivant).equals(suivant + " est un Identificateur"))
                    {
                        if (it.hasNext())
                        {
                            suivant = it.next();
                            jTextArea1.append(suivant + " ");
                            if(suivant.equals("to"))
                            {
                                if (it.hasNext())
                                {
                                    suivant = it.next();
                                    jTextArea1.append(suivant + " ");
                                    if(identification(suivant).equals(suivant + " est un Identificateur"))
                                    {
                                        if (it.hasNext())
                                        {
                                            suivant = it.next();
                                            jTextArea1.append(suivant + " ");
                                            if(suivant.equals(";;"))
                                            {
                                                jTextArea1.append(" - Affectation de valeur entre variables reconnue\n");
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
                jTextArea1.append(" - Affectation non-valide\n");
                return false;
                
            case "If":
                if (it.hasNext())
                {
                    jTextArea1.append("If ");
                    it.next();
                    io.next(); io.next();
                    suivant = it.next();
                    jTextArea1.append(suivant + " ");
                    if(suivant.equals("--"))
                    {
                        if (it.hasNext())
                        {
                            suivant = it.next();
                            io.next();
                            jTextArea1.append(suivant + " ");
                            if(identification(suivant).equals(suivant + " est un Identificateur"))
                            {
                                if (it.hasNext())
                                {
                                    suivant = it.next();
                                    io.next();
                                    jTextArea1.append(suivant + " ");
                                    if(suivant.equals("<") || suivant.equals(">") || suivant.equals("<=") || suivant.equals(">=") || suivant.equals("="))
                                    {
                                        if (it.hasNext())
                                        {
                                            suivant = it.next();
                                            io.next();
                                            jTextArea1.append(suivant + " ");
                                            if(identification(suivant).equals(suivant + " est un Identificateur") || identification(suivant).equals(suivant + " est un Nombre Entier") || identification(suivant).equals(suivant + " est un Nombre Reel"))
                                            {
                                                if (it.hasNext())
                                                {
                                                    suivant = it.next();
                                                    io.next();
                                                    jTextArea1.append(suivant + " ");
                                                    if(suivant.equals("--"))
                                                    {
                                                        jTextArea1.append(" - Condition alors reconnue\n");
                                                        if (it.hasNext())
                                                        {
                                                            //suivant = it.next();
                                                            return instruction(suivant);
                                                        }                    
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
                jTextArea1.append(" - Condition non-valide\n");
                return false;

            case "Int_Number":
                if (it.hasNext())
                {
                    jTextArea1.append("Int_Number ");
                    it.next();
                    suivant = it.next();
                    jTextArea1.append(suivant + " ");
                    if(suivant.equals(":"))
                    {
                        if (it.hasNext())
                        {
                            suivant = it.next();
                            jTextArea1.append(suivant + " ");
                            if(identification(suivant).equals(suivant + " est un Identificateur"))
                            {
                                if (it.hasNext())
                                {
                                    compteur++;
                                    suivant = it.next();
                                    jTextArea1.append(suivant + " ");
                                    test: 
                                    while(!suivant.equals(";;") && it.hasNext())
                                    {
                                        if(suivant.equals(","))
                                        {
                                            if (it.hasNext())
                                            {
                                                suivant = it.next();
                                                jTextArea1.append(suivant + " ");
                                                if(identification(suivant).equals(suivant + " est un Identificateur"))
                                                {
                                                    if (it.hasNext())
                                                    {
                                                        compteur++;
                                                        suivant = it.next();
                                                        jTextArea1.append(suivant + " ");
                                                    }
                                                }

                                                else
                                                {
                                                    jTextArea1.append(" - Déclaration d'entiers non-valide\n");
                                                    return false;
                                                }
                                            }
                                        }

                                        continue test;
                                    }
                                    
                                    if(suivant.equals(";;"))
                                    {
                                        jTextArea1.append(" - Déclaration de " + compteur + " entiers reconnue\n");
                                        return true; 
                                    }
                                }
                            }
                        }
                    }
                }
                
                jTextArea1.append(" - Déclaration d'entiers non-valide\n");
                return false;

            case "Real_Number" :
                if (it.hasNext())
                {
                    jTextArea1.append("Real_Number ");
                    it.next();
                    suivant = it.next();
                    jTextArea1.append(suivant + " ");
                    if(suivant.equals(":"))
                    {
                        if (it.hasNext())
                        {
                            suivant = it.next();
                            jTextArea1.append(suivant + " ");
                            if(identification(suivant).equals(suivant + " est un Identificateur"))
                            {
                                if (it.hasNext())
                                {
                                    compteur++;
                                    suivant = it.next();
                                    jTextArea1.append(suivant + " ");
                                    test: 
                                    while(!suivant.equals(";;") && it.hasNext())
                                    {
                                        if(suivant.equals(","))
                                        {
                                            if (it.hasNext())
                                            {
                                                suivant = it.next();
                                                jTextArea1.append(suivant + " ");
                                                if(identification(suivant).equals(suivant + " est un Identificateur"))
                                                {
                                                    if (it.hasNext())
                                                    {
                                                        compteur++;
                                                        suivant = it.next();
                                                        jTextArea1.append(suivant + " ");
                                                    }
                                                }

                                                else
                                                {
                                                    jTextArea1.append(" - Déclaration de réels non-valide\n");
                                                    return false;
                                                }
                                            }
                                        }

                                        continue test;
                                    }
                                    
                                    if(suivant.equals(";;"))
                                    {
                                        jTextArea1.append(" - Déclaration de " + compteur + " réels reconnue\n");
                                        return true; 
                                    }
                                }
                            }
                        }
                    }
                }
                
                jTextArea1.append(" - Déclaration de réels non-valide\n");
                return false;

            case "Start_Program" :
                jTextArea1.append("Start_Program ");
                jTextArea1.append(" - Début de programme\n");
                return true;

            case "End_Program" :
                jTextArea1.append("End_Program ");
                jTextArea1.append(" - Fin de programme\n");
                return true;

            case "//." :
                jTextArea1.append("//. ");
                suivant = it.next();
                while(it.hasNext())
                {
                    jTextArea1.append(it.next() + " ");
                }
                jTextArea1.append(" - Commentaire reconnu\n");
                return true;

            case "ShowMes" :
                if (it.hasNext())
                {
                    jTextArea1.append("ShowMes ");
                    it.next();
                    suivant = it.next();
                    jTextArea1.append(suivant + " ");
                    if(suivant.equals(":"))
                    {
                        if (it.hasNext())
                        {
                            suivant = it.next();
                            jTextArea1.append(suivant + " ");
                            if(suivant.equals("\""))
                            {
                                if(it.hasNext())
                                {
                                    suivant = it.next();
                                    jTextArea1.append(suivant + " ");
                                    while(it.hasNext() && !suivant.equals("\""))
                                    {
                                        suivant = it.next();
                                        jTextArea1.append(suivant + " ");
                                    }

                                    if (it.hasNext())
                                    {
                                        suivant = it.next();
                                        jTextArea1.append(suivant + " ");
                                        if (suivant.equals(";;"))
                                        {
                                            jTextArea1.append(" - Message reconnu\n");
                                            return true;
                                        }                                        
                                    }
                                }
                            }
                        }
                    }
                }

                jTextArea1.append(" - Message non-reconnu\n");
                return false;

            case "ShowVal" :
                if (it.hasNext())
                {
                    jTextArea1.append("ShowVal ");
                    it.next();
                    suivant = it.next();
                    jTextArea1.append(suivant + " ");
                    if(suivant.equals(":"))
                    {
                        if (it.hasNext())
                        {
                            suivant = it.next();
                            jTextArea1.append(suivant + " ");
                            if (identification(suivant).equals(suivant + " est un Identificateur"))
                            {
                                if (it.hasNext())
                                {
                                    suivant = it.next();
                                    jTextArea1.append(suivant + " ");
                                    if (suivant.equals(";;"))
                                    {
                                        jTextArea1.append(" - Affichage de variable reconnu\n");
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }

                jTextArea1.append(" - Affichage de variable non-valide\n");
                return false;

            case "Start" :
                jTextArea1.append("Start ");
                jTextArea1.append(" - Début d'un bloc d'instruction\n");
                return true;

            case "Finish" :
                jTextArea1.append("Finish ");
                jTextArea1.append(" - Fin d'un bloc d'instruction\n");
                return true;

            case "Else" :
                jTextArea1.append("Else ");
                jTextArea1.append(" - Sinon\n");
                return true;
        }

        return false;
    }

    private void analyseSyntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyseSyntActionPerformed
            if (jTextArea1.getText().equals("") || jTextArea1.getText().equals("Erreur : Veuillez choisir un fichier !"))
            {
                jTextArea1.setText("Erreur : Veuillez choisir un fichier !");
                return;
            }
            
            try
            {
                FileReader read = new FileReader(chemin);
                BufferedReader br = new BufferedReader(read);
                jTextArea1.read(br, null);
                br.close();
                //br = new BufferedReader(new FileReader("Code.compila"));
                
                List<String> mots = new ArrayList<String>();
                
                DefaultCaret caret = (DefaultCaret) jTextArea1.getCaret();
                caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

                String[] words;
                List<String> list = null;

                words = jTextArea1.getText().split("\n");

                list = Arrays.asList(words);

                for(int j = 0; j < list.size(); j++)
                    mots.add(list.get(j));
                
                FileWriter fileWriter = new FileWriter("Syntaxique.txt");
                
                jTextArea1.setText("");
                for(String ligne:mots)
                {
                    instruction(ligne);                
                }       
                
                fileWriter.write(jTextArea1.getText() + "\n");
                fileWriter.close();
                br.close();
            }
            
            catch (FileNotFoundException ex) 
            {
                Logger.getLogger(Compilation.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IOException ex) 
            {
                Logger.getLogger(Compilation.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_analyseSyntActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        jTextArea1.setText("");
    }//GEN-LAST:event_saveActionPerformed
   
    private void analyseLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyseLexActionPerformed
            if (jTextArea1.getText().equals("") || jTextArea1.getText().equals("Erreur : Veuillez choisir un fichier !"))
            {
                jTextArea1.setText("Erreur : Veuillez choisir un fichier !");
                return;
            }
            
            try
            {
                FileReader read = new FileReader(chemin);
                BufferedReader br = new BufferedReader(read);
                jTextArea1.read(br, null);
                //br.close();
                //br = new BufferedReader(new FileReader("Compilation.txt"));
	            
                String sCurrentLine, lastLine = "";

                while ((sCurrentLine = br.readLine()) != null) 
                    lastLine = sCurrentLine;

                if (lastLine.equals("End_Program : Mot réservé fin d'un programme"))
                    return;
				
                List<String> mots = new ArrayList<String>();
                DefaultCaret caret = (DefaultCaret) jTextArea1.getCaret();
                caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

                String[] words;
                List<String> list = null;

                words = jTextArea1.getText().split(" |\n|\t");

                list = Arrays.asList(words);

                for(int j = 0; j < list.size(); j++)
                    mots.add(list.get(j));
                
                FileWriter fileWriter = new FileWriter("Lexicale.txt");
                
                jTextArea1.setText("");
                for(String mot:mots)
                {
                    fileWriter.write(identification(mot) + "\n");
                    jTextArea1.append(identification(mot) + "\n");       
                }

                fileWriter.close();
                br.close();
            }
            
            catch (FileNotFoundException ex) 
            {
                Logger.getLogger(Compilation.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IOException ex) 
            {
                Logger.getLogger(Compilation.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_analyseLexActionPerformed

    private void changerFichier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changerFichier1ActionPerformed


        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f= chooser.getSelectedFile();
        String fileName= f.getAbsolutePath();
        chemin = f.getAbsolutePath();
        
        try {
            FileReader read = new FileReader(fileName);
            BufferedReader br = new BufferedReader(read);
            jTextArea1.read(br, null);
            br.close();
            FileWriter fileWriter = new FileWriter("Compilation.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Compilation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Compilation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_changerFichier1ActionPerformed

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
                     
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compilation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compilation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analyseLex;
    private javax.swing.JButton analyseSem;
    private javax.swing.JButton analyseSynt;
    private javax.swing.JButton changerFichier1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
