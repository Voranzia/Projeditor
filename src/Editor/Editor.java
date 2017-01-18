package Editor;

import java.io.IOException;

class Editor {
    public static void main (String [] args) throws IOException{
        String[] actions = {"1 : Ouvrir une image", "2 : Rotation de 90]", "3 : Rogner l'image", "4 : Réduire l'image de moitié", "5 : Tracer une figure", "6 : Revenir à  un état précédent", "7 : Sortie"};
        String[] figures = {"1 : Ajout d'un rectangle", "2 : Ajout d'un cercle", "3 : Ajout d'un triangle", "4 : Ajout d'un trait"};
        String[] couleurs = {"1 : bleu", "2 : rouge", "3 : vert", "4 : jaune", "5 : violet", "6 : rose", "7 : orange", "8 : marron", "9 : gris", "10 : noir", "11 : blanc"};
        Menu [] men = new Menu[3];
        boolean saisieOk;
        try {
            men[0] = new Menu("Que voulez vous faire ?", actions);
            men[1] = new Menu("Quelle figure voulez vous ajouter ?", figures);
            men[2] = new Menu("Quelle couleur souhaitez-vous appliquer ?", couleurs);
        }catch(ChoixPasBon ex){
        }
        for (int i=0;i<3;i++){
            do{
                try{
                    saisieOk = true;
                    men[i%3].executerMenu();
                }catch(HorsIntervalle ex){
                    Terminal.ecrireStringln ("Vous devez entrer un des choix proposés.");
                    saisieOk = false;
                }catch(PasNombre ex){
                    Terminal.ecrireStringln ("Vous devez entrer un nombre.");
                    saisieOk = false;
                }
            }while(!saisieOk);
        }
    }
}

class Menu {
    String[] tabChoix;
    String question;
    Image imageRef;
    Afficheur editeur;

    Menu(String q, String[] t) throws ChoixPasBon, IOException{
        if (t.length > 11){
            throw new ChoixPasBon();
        }
        tabChoix = t;
        question = q;
    }
    void afficheQuestions(){
        Terminal.ecrireStringln(question);
        for(int i=0; i<tabChoix.length; i++){
            Terminal.ecrireStringln(tabChoix[i] + ": tapez " + (i+1));
        }
        Terminal.ecrireString("Entrez votre choix: ");
    }
    int charToInt(char c) throws PasNombre{
        if (c == '1'){
            return 1;
        }else if(c == '2'){
            return 2;
        }else if(c == '3'){
            return 3;
        }else if(c == '4'){
            return 4;
        }else if(c == '5'){
            return 5;
        }else if(c == '6'){
            return 6;
        }else if(c == '7'){
            return 7;
        }else if(c == '8'){
            return 8;
        }else if(c == '9'){
            return 9;
        }else if(c == '0'){
            return 0;
        }
        throw new PasNombre();
    }
    int Saisir() throws PasNombre, HorsIntervalle, IOException{
        char rep = Terminal.lireChar();
        int repInt;
        repInt = charToInt(rep);
        if ((repInt ==0) || (repInt > tabChoix.length)){
            throw new HorsIntervalle();
        }
        executerAction(repInt);
        return repInt;

    }
    int executerMenu() throws PasNombre, HorsIntervalle, IOException{
        afficheQuestions();
        return Saisir();
    }
    void executerAction (int repInt) throws IOException {
        if (repInt == 1) {
            Ouvrir();
        } else if (repInt == 2) {
            Tourner();
        } else if (repInt == 3) {
            Decouper();
        } else if (repInt == 4) {
            Reduire();
        } else if (repInt == 5) {
            Tracer();
        } else if (repInt == 6) {
            Annuler();
        } else if (repInt == 7) {
            Sortir();
        }
    }
    void Ouvrir() throws IOException{
        Terminal.ecrireStringln ("Entrez le nom du fichier avec son extension");
        imageRef.imageNom = Terminal.lireString();
        imageRef.imageTab = ImageUtil.readImage(imageRef.imageNom);
        imageRef.largeur = ImageUtil.getImageWidth(imageRef.imageNom);
        imageRef.hauteur = ImageUtil.getImageHeight(imageRef.imageNom);
        Afficheur reference = new Afficheur(imageRef.largeur, imageRef.hauteur, imageRef.imageTab, 100, 100, imageRef.imageNom);
        editeur = new Afficheur(imageRef.largeur, imageRef.hauteur, imageRef.imageTab, 130+imageRef.largeur, 100, imageRef.imageNom);
        //Sauvegarde.creationEtat(imageRef.imageTab);
    }
    void Tourner(){
        Actions rotation = new Actions();
        rotation.Tourner(imageRef.imageTab);
        editeur.update(imageRef.imageTab);
    }
    void Decouper(){
            //implémenter l'appel à la méthode decouper de Actions
            //afficher le résultat et le sauvegarder
        Actions decoupe = new Actions();
        decoupe.Decouper(imageRef.imageTab);
        editeur.update(imageRef.imageTab);
    }
    void Reduire(){
        //implémenter l'appel à la méthode reduire de Actions
        //afficher le résultat et le sauvegarder
        Actions reduction = new Actions();
        reduction.Reduire(imageRef.imageTab);
        editeur.update(imageRef.imageTab);
    }
    void Tracer(){
        //implémenter l'appel à la méthode decouper de Actions
        //afficher le résultat et le sauvegarder
        Actions dessin = new Actions();
        dessin.Tracer(imageRef.imageTab);
        editeur.update(imageRef.imageTab);
    }
    void Annuler(){
        //implémenter l'appel à la version précédente d'imageTab
        //afficher le résultat et le sauvegarder
    }
    void Sortir(){
        //sortir du programme
    }
}

class ChoixPasBon extends Exception{}
class PasNombre extends Exception{}
class HorsIntervalle extends Exception{}
