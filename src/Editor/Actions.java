package Editor;

public class Actions {
    int[] Decouper(int[] tempTab){
        return tempTab;
    }
    int[] Tourner(int[] tempTab){
        //méthode à implémenter
        return tempTab;
    }
    int[] Reduire(int[] tempTab){
        //méthode à implémenter
        return tempTab;
    }
    int[] Tracer(int[] tempTab){
        //implémenter appel au menu pour le choix de forme puis le choix de couleur
        //implémenter les appels en fonction des choix
        return tempTab;
    }
}

class Point { // pas vraiment utile en tant qu'action, mais nécessaire pour les calculs des formes géométriques.
    double x, y;
    int choixcol=10;
    int couleur;
    Point(double xi, double yi, int choixcol) {
        this.x = xi;
        this.y = yi;
        this.couleur = Palette.colorPicker(choixcol);
    }
}

class Trait{
    int[] tempTab;
    Point origine, p2;
    Trait(Point p1, Point p2) {//calcule la droite entre les 2 points indiqués
        //méthode à implémenter
    }
    static Double Distance(Point origine, Point p2){//calcule a distance entre 2 points
        return Math.sqrt((origine.x-p2.x)*(origine.x-p2.x)+(origine.y-p2.y)*(origine.y-p2.y));
    }
    public int[] tempTab(){
        //méthode à implémenter, pour chaque pixel vérifie si Trait est vrai pour ces coordonnées, si oui remplace l'int dans la case du tableau par couleur
        return tempTab;
    }
}

class Triangle{
    int[] tempTab;
    Point origine, sommet2, sommet3;
    Triangle(Point p1, Point p2, Point p3) {
        //méthode à implémenter
    }
    public int[] tempTab(){
        //méthode à implémenter
        return tempTab;
    }
}

class Rectangle{
    int[] tempTab;
    Point origine;
    Double distHor, distVer;
    Rectangle(Point bg, Double dh, Double dv){
        //méthode à implémenter
    }
    public int[] tempTab(){
        //méthode à implémenter
        return tempTab;
    }
}

class Cercle{
    int[] tempTab;
    Point origine;
    Double rayon;
    Cercle(Point centre, double r) {
        //méthode à implémenter
    }
    public int[] tempTab(){
        //méthode à implémenter
        return tempTab;
    }
}

