package fr.pgah;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Intro extends ApplicationAdapter {
  SpriteBatch batch; // variables (SpriteBatch : Type de la variable | batch : nom de la variable)

  Texture[] imgs; // variables (Si le type commence par une majuscule, c'est un type objet | Si le type commence par une minuscule, c'est un type primitif)
  int[] coordonneesX;
  int[] coordonneesY;
  int[] hauteursImgs;
  boolean[] montent; //int directionEnY 0 pour monter et 1 pour descendre

  int hauteurFenetre;

  public void create() { // méthode (create : nom de la méthode)
    batch = new SpriteBatch();  // méthode (= : affectation | new : instanciation)
    // img = new Texture("sio.jpg");
    imgs = new Texture[2];  // méthode
    imgs[0] = new Texture("sio.jpg");  //affectation
    imgs[1] = new Texture("sio.jpg");

    coordonneesX = new int[2];
    coordonneesX[0] = 0;
    coordonneesX[1] = 100;

    coordonneesY = new int[2];
    coordonneesY[0] = 0;
    coordonneesY[1] = 200;

    hauteursImgs = new int[2];
    hauteursImgs[0] = imgs[0].getHeight();
    hauteursImgs[1] = imgs[1].getHeight();

    montent = new boolean[2];
    montent[0] = true;
    montent[1] = false;
    hauteurFenetre = Gdx.graphics.getHeight();
  }

  public void render() {
    reinitialiserArrierePlan(); // corps de la méthode
    testerBordures();
    majCoordonnees();
    dessiner();
  }

  public void reinitialiserArrierePlan() {
    ScreenUtils.clear(1, 0, 0, 1);
  }

  public void testerBordures() {
    // Tester bordure haute
    for (int i = 0; i <= 1; i++) {
      if (coordonneesY[i] + hauteursImgs[i] == hauteurFenetre) {
        montent[i] = false;
      }

      // Tester bordure basse)
      if (coordonneesY[i] == 0) {
        montent[i] = true;
      }
    }

  }

  private void majCoordonnees() {
    for (int i = 0; i <= 1; i++) { // corps de la méthode
      coordonneesX[i] = coordonneesX[i] + 1;
    }

    for (int i = 0; i <= 1; i++) {
      if (montent[i]) {
        coordonneesY[i] = coordonneesY[i] + 1; // incrémentation
      } else {
        coordonneesY[i] = coordonneesY[i] - 1; // décrémentation
      }
    }

    if (onMonte) {
      y = y + 1; // incrémentation
    } else {
      y = y - 1; // décrémentation
    }
  }

  private void dessiner() {
    batch.begin();  // corps de la méthode (begin : appel de méthode)
    batch.draw(img, x, y);
    batch.end();
  }
}
