package fr.pgah;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels.TextureRegionInitializer;
import com.badlogic.gdx.utils.ScreenUtils;

public class Intro extends ApplicationAdapter {
  SpriteBatch batch; // variables (SpriteBatch : Type de la variable | batch : nom de la variable)
 
  Texture [] imgs; // variables (Si le type commence par une majuscule, c'est un type objet | Si le type commence par une minuscule, c'est un type primitif)
  int [] coordonneesX;
  int [] coordonneesY;
  int [] hauteurImgs;
  boolean [] montent;        //int directionEnY 0 pour monter et 1 pour descendre
  int hauteurFenetre;
  
  @Override
  public void create() { // méthode (create : nom de la méthode)
    batch = new SpriteBatch(); // méthode (= : affectation | new : instanciation)
    
    imgs = new Texture [2]; // méthode
    imgs [0] = new Texture ("sio.jpg"); //affectation
    imgs [1] = new Texture ("baldogic.jpg");

    coordonneesX = new int[2];
    coordonneesX[0] =0;
    coordonneesX[1] = 100;
    
    coordonneesY = new int[2];
    coordonneesY [0] =0;
    coordonneesY[1] =200;

    hauteurImgs = new int[2];
    hauteurImgs[0] = imgs[0].getHeight();
    hauteurImgs[1] = imgs[1].getHeight();

    montent =new boolean[2];
    montent[0]= true;
    montent[2]= false;
  }

  @Override
  public void render() {
    reinitialiserBackgroud(); // corps de la méthode
    testerBordures();
    majCoordonnees();
    dessiner();
  }

  private void dessiner() {
    batch.begin();      // corps de la méthode (begin : appel de méthode)


    for (int i = 0; i <= 1; i++){ // corps de la méthode
      batch.draw (imgs[i], coordonneesX[i],coordonneesY[i]);
    }
    batch.end(); // corps de la méthode
  }

  private void majCoordonnees() {
    for (int i = 0;i <= 1;i++) {
     coordonneesX[i] = coordonneesY[i] + 1;
     
     if (montent[i]) {
       coordonneesX
     }
    }
      
     
    }
  }

  private void testerBordures() {
    // if (Tape la bordure haute)
    if(y + hauteurImg == hauteurFenetre) {
      //chnage la facon de modifier y
      onmonte = false;
    }
    // if (Tape la bordure basse)
    if(y == 0) {
      onmonte = true;
    }
  }

  private void reinitialiserBackgroud() {
    ScreenUtils.clear(1, 0, 0, 1);
  }
}