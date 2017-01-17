package Editor;

import java.io.*;

class Editor {
    public static void main (String [] args){
        int[] imageTab;
        String[] actions = {"1 : Ouvrir une image", "2 : Rotation de 90]", "3 : Rogner l'image", "4 : Réduire l'image de moitié", "5 : Tracer une figure", "6 : Revenir à  un état précédent", "7 : Sortie"};
        String[] figures = {"1 : Ajout d'un rectangle", "2 : Ajout d'un cercle", "3 : Ajout d'un triangle", "4 : Ajout d'un trait"};
        String[] couleurs = {"1 : bleu", "2 : rouge", "3 : vert", "4 : jaune", "5 : violet", "6 : rose", "7 : orange", "8 : marron", "9 : gris", "10 : noir", "11 : blanc"};
        Menu [] men = new Menu[2];
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
    String imageNom="";
    int largeur;
    int hauteur;


    Menu(String q, String[] t) throws ChoixPasBon{
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
    int saisir() throws PasNombre, HorsIntervalle{
        char rep = Terminal.lireChar();
        int repInt;
        repInt = charToInt(rep);
        if ((repInt ==0) || (repInt > tabChoix.length)){
            throw new HorsIntervalle();
        }
        return repInt;
        executerAction(repInt);
    }
    int executerMenu() throws PasNombre, HorsIntervalle{
        afficheQuestions();
        return saisir();
    }
    void executerAction(int repInt) {
        if (repInt == 1) {
            ouvrir();
        } else if (repInt == 2) {
            tourner();
        } else if (repInt == 3) {
            decouper();
        } else if (repInt == 4) {
            reduire();
        } else if (repInt == 5) {
            tracer();
        } else if (repInt == 6) {
            annuler();
        } else if (repInt == 7) {
            sortir();
        }
    }
    int[] ouvrir() throws IOException{
        Terminal.ecrireStringln ("Entrez le nom du fichier avec son extension");
        String imageNom = Terminal.lireString();
        Image monImage = new Image
        monImage.imageTab = ImageUtil.readImage(monImage.imageNom);
        monImage.largeur = ImageUtil.getImageWidth(monImage.imageNom);
        monImage.hauteur = ImageUtil.getImageHeight(monImage.imageNom);
        Afficheur imageReference = new Afficheur(monImage.largeur, monImage.hauteur, monImage.imageTab, 100, 100, monImage.imageNom);
        Afficheur imageEditeur = new Afficheur(monImage.largeur, monImage.hauteur, monImage.imageTab, 130+monImage.largeur, 100, imageNom);
        Sauvegarde.creationEtat(monImage);
    }
    int[] tourner(){
        Actions rotation = new Actions;
        rotation.Tourner(imageTab);
        imageTab.majAfficheur(imageEditeur);
    }
    int[] decouper(imageTab){
            //implémenter l'appel à la méthode decouper de Actions
            //afficher le résultat et le sauvegarder
        imageEditeur = new MonAfficheur.update(int[] imageTab);

    }
    int[] reduire(imageTab){
        //implémenter l'appel à la méthode reduire de Actions
        //afficher le résultat et le sauvegarder
        imageEditeur = new MonAfficheur.update(int[] imageTab);
        Actions.reduire()

    }
    int[] tracer(imageTab){
        //implémenter l'appel à la méthode decouper de Actions
        //afficher le résultat et le sauvegarder
    }
    int[] annuler(){
        //implémenter l'appel à la version précédente d'imageTab
        //afficher le résultat et le sauvegarder
    }
    void sortir(){
        //sortir du programme
    }
}

class IOException extends Exception{}
class ChoixPasBon extends Exception{}
class PasNombre extends Exception{}
class HorsIntervalle extends Exception{}


/**public class MonAfficheur {
    public Afficheur instAfficheur;
    public void monAfficheur(int width, int height, int[] pixels, int posX, int posY, String title){
        instAfficheur = new Afficheur(width, height, pixels, posX, posY, title);
    }
    public void majAfficheur(int[] pixels){
        instAfficheur.update(pixels);
    }
}**/
