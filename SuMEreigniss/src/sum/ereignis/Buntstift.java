 package sum.ereignis;
 
 import java.awt.BasicStroke;
 import java.awt.Color;
 import java.awt.Font;
 import java.awt.Graphics2D;
 import java.awt.geom.Ellipse2D;
 import java.awt.geom.Line2D;
 import java.awt.geom.Rectangle2D;
 
 public class Buntstift extends Stift
 {
   private String zAktuellFont = "Helvetica";
   private int zSchriftStil = 0;
   private int zSchriftGroesse = 12;
   private Font zSchriftArt = Schrift.STANDARDSCHRIFT;
   private Color zFarbe = Color.black;
   private int zLinienbreite = 1;
   private int zMuster = 0;
 
   public Buntstift()
   {
   }
 
   public Buntstift(Fenster pFenster)
   {
     super(pFenster);
   }
 
   public void setzeFarbe(Color pFarbe)
   {
     this.zFarbe = pFarbe;
   }
 
   public void setzeFarbe(int pFarbe)
   {
     if (pFarbe < 0)
       pFarbe = 0;
     pFarbe %= 13;
     switch (pFarbe)
     {
     case 0:
       setzeFarbe(Color.black);
       break;
     case 1:
       setzeFarbe(Color.blue);
       break;
     case 2:
       setzeFarbe(Color.cyan);
       break;
     case 3:
       setzeFarbe(Color.darkGray);
       break;
     case 4:
       setzeFarbe(Color.gray);
       break;
     case 5:
       setzeFarbe(Color.green);
       break;
     case 6:
       setzeFarbe(Color.lightGray);
       break;
     case 7:
       setzeFarbe(Color.magenta);
       break;
     case 8:
       setzeFarbe(Color.orange);
       break;
     case 9:
       setzeFarbe(Color.pink);
       break;
     case 10:
       setzeFarbe(Color.red);
       break;
     case 11:
       setzeFarbe(Color.white);
       break;
     case 12:
       setzeFarbe(Color.yellow);
     }
   }
 
   public void setzeLinienbreite(int pBreite)
   {
     if (pBreite > 0)
     {
       this.zLinienbreite = pBreite;
       this.hatStroke = new BasicStroke(pBreite * 1.0F, 0, 0);
     }
   }
 
   public void setzeLinienBreite(int pBreite)
   {
     setzeLinienbreite(pBreite);
   }
 
   public int linienbreite()
   {
     return this.zLinienbreite;
   }
 
   public int linienBreite()
   {
     return this.zLinienbreite;
   }
 
   public void setzeSchriftart(String pArt)
   {
     this.zAktuellFont = pArt;
   }
 
   public void setzeSchriftArt(String pArt)
   {
     this.zAktuellFont = pArt;
   }
 
   public void setzeSchriftgroesse(int pGroesse)
   {
     this.zSchriftGroesse = pGroesse;
   }
 
   public void setzeSchriftGroesse(int pGroesse)
   {
     this.zSchriftGroesse = pGroesse;
   }
 
   public void setzeSchriftstil(int pStil)
   {
     this.zSchriftStil = pStil;
   }
 
   public void setzeSchriftStil(int pStil)
   {
     this.zSchriftStil = pStil;
   }
 
   public void setzeFuellmuster(int pMuster)
   {
     this.zMuster = pMuster;
   }
 
   public void setzeFuellMuster(int pMuster)
   {
     this.zMuster = pMuster;
   }
 
   @Override
   public void zeichneRechteck(double pBreite, double pHoehe)
   {
     
     if (this.kenntPrivatschirm.g2d != null)
     {
       setzeZustand(this.kenntPrivatschirm.g2d);
       if (this.zMuster == 0) {
         this.kenntPrivatschirm.g2d.drawRect((int)this.zStiftH, (int)this.zStiftV, (int)pBreite, (int)pHoehe);
           
            
       }
       else
       {
           this.kenntPrivatschirm.g2d.fillRect((int)this.zStiftH, (int)this.zStiftV, (int)pBreite, (int)pHoehe);
         //g.fill(new Rectangle2D.Double(this.zStiftH, this.zStiftV, pBreite, pHoehe));
          
         
       }
     }
   }
 
   @Override
   public void zeichneKreis(double pRadius)
   {
     Graphics2D g = get2DGraphics(this.kenntPrivatschirm.g());
     if (g != null)
     {
       setzeZustand(g);
       if (this.zMuster == 0) {
         g.draw(new Ellipse2D.Double(this.zStiftH - pRadius, this.zStiftV - pRadius, 2.0D * pRadius, 2.0D * pRadius));
       }
       else
         g.fill(new Ellipse2D.Double(this.zStiftH - pRadius, this.zStiftV - pRadius, 2.0D * pRadius, 2.0D * pRadius));
     }
   }
 
   @Override
   protected void zeichneLinie(double x1, double y1, double x2, double y2)
   {
     Graphics2D g = get2DGraphics(this.kenntPrivatschirm.g());
     if (g != null)
     {
       setzeZustand(g);
       g.draw(new Line2D.Double(x1, y1, x2, y2));
     }
   }
 
   public int textbreite(String pText)
   {
     Graphics2D g = get2DGraphics(this.kenntPrivatschirm.g());
     if (g != null)
     {
       setzeZustand(g);
       return g.getFontMetrics().stringWidth(pText);
     }
 
     return 12;
   }
 
   public int zeichenbreite(char pZeichen)
   {
     String lText = "" + pZeichen;
     return textbreite(lText);
   }
 
   public int zahlbreite(int pZahl)
   {
     String lText = "" + pZahl;
     return textbreite(lText);
   }
 
   public int zahlbreite(double pZahl)
   {
     String lText = "" + pZahl;
     return textbreite(lText);
   }
 
   public int textBreite(String pText)
   {
     return textbreite(pText);
   }
 
   public int zeichenBreite(char pZeichen)
   {
     return zeichenbreite(pZeichen);
   }
 
   public int zahlBreite(int pZahl)
   {
     return zahlbreite(pZahl);
   }
 
   public int zahlBreite(double pZahl)
   {
     return zahlbreite(pZahl);
   }
 
   @Override
   protected void setzeZustand(Graphics2D g)
   {
     if ((this.zMuster == 2) && (this.zFarbe.getTransparency() != 3))
     {
       this.zFarbe = new Color(this.zFarbe.getRed(), this.zFarbe.getGreen(), this.zFarbe.getBlue(), 128);
     }
     else if ((this.zMuster != 2) && (this.zFarbe.getTransparency() != 1))
     {
       this.zFarbe = new Color(this.zFarbe.getRed(), this.zFarbe.getGreen(), this.zFarbe.getBlue());
     }
     if (this.zSchreibModus == 1)
     {
       g.setPaint(this.kenntPrivatschirm.hintergrundfarbe());
       g.setPaintMode();
     }
     else if (this.zSchreibModus == 0)
     {
       g.setPaint(this.zFarbe);
       g.setPaintMode();
     }
     else
     {
       g.setPaint(this.zFarbe);
       g.setXORMode(this.kenntPrivatschirm.hintergrundfarbe());
     }
     this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
     g.setFont(this.zSchriftArt);
   }
 
   protected void setzeStandard()
   {
     this.zStiftH = 0.0D;
     this.zStiftV = 0.0D;
     this.zHoch = true;
     this.zWinkel = 0.0D;
     this.zSchreibModus = 0;
     this.zAktuellFont = "Helvetica";
     this.zSchriftStil = 0;
     this.zSchriftGroesse = 12;
     this.zSchriftArt = Schrift.STANDARDSCHRIFT;
     this.zFarbe = Color.black;
     this.zLinienbreite = 1;
     this.zMuster = 0;
   }
 }

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMEreignis.jar
 * Qualified Name:     sum.ereignis.Buntstift
 * JD-Core Version:    0.6.0
 */