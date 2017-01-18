package Editor;

public class Actions {
    void Decouper(int[] tempTab){
        //méthode à implémenter qui modifie le tableau imageTab de l'objet imageRef
    }
    void Tourner(int[] tempTab){
        //méthode à implémenter qui modifie le tableau imageTab de l'objet imageRef
    }
    void Reduire(int[] tempTab){
        //méthode à implémenter qui modifie le tableau imageTab de l'objet imageRef
    }
    void Tracer(int[] tempTab){
        //implémenter appel aux fonctions de Menu pour le choix de forme puis le choix de couleur
        //récupérer le point d'origine et les éventuels autres points avec Afficheur.mouseClicked()
        //implémenter les appels en fonction des choix
    }
}

class Point { // pas vraiment utile en tant qu'action, mais nécessaire pour les calculs des formes géométriques.
    double x, y;
    Point(double xi, double yi) {
        this.x = xi;
        this.y = yi;
    }
}

class Trait{
    int[] tempTab;
    int choixcol=10;
    int couleur;
    Point origine, p2;
    Trait(Point p1, Point p2) {
        //méthode à implémenter
        this.couleur = Palette.colorPicker(choixcol);
    }
        static Double Distance(Point origine, Point p2){//calcule a distance entre 2 points
        return Math.sqrt((origine.x-p2.x)*(origine.x-p2.x)+(origine.y-p2.y)*(origine.y-p2.y));
    }
    void MajTableau(int[] tempTab, int couleur){
        //méthode à implémenter, pour chaque pixel du tableau vérifie si Trait est vrai pour ces coordonnées, si oui remplace l'int dans la case du tableau par couleur
        //on met à jour tempTab
    }
}

class Triangle{
    int[] tempTab;
    int choixcol=10;
    int couleur;
    Point origine, sommet2, sommet3;
    Triangle(Point p1, Point p2, Point p3) {
        //méthode à implémenter
        this.couleur = Palette.colorPicker(choixcol);
    }
    void MajTableau(int[] tempTab, int couleur){
        //méthode à implémenter, pour chaque pixel du tableau vérifie si Triangle est vrai pour ces coordonnées, si oui remplace l'int dans la case du tableau par couleur
        //on met à jour tempTab
    }
}

class Rectangle{
    int[] tempTab;
    int choixcol=10;
    int couleur;
    Point origine;
    Double distHor, distVer;
    Rectangle(Point bg, Double dh, Double dv){
        //méthode à implémenter
    }
    void MajTableau(int[] tempTab, int couleur){
        //méthode à implémenter, pour chaque pixel du tableau vérifie si Triangle est vrai pour ces coordonnées, si oui remplace l'int dans la case du tableau par couleur
        //on met à jour tempTab
    }
}

class Cercle{
    int[] tempTab;
    int choixcol=10;
    int couleur;
    Point origine;
    Double rayon;
    Cercle(Point centre, double r) {
        //méthode à implémenter
    }
    void MajTableau(int[] tempTab, int couleur){
        //méthode à implémenter, pour chaque pixel du tableau tempTab vérifie si Triangle est vrai pour ces coordonnées, si oui remplace l'int dans la case du tableau par couleur
        //on met à jour tempTab
    }
}

