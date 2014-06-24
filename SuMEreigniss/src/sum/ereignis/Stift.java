 package sum.ereignis;
 
 import java.awt.BasicStroke;
 import java.awt.Color;
 import java.awt.FontMetrics;
 import java.awt.Graphics;
 import java.awt.Graphics2D;
 import java.awt.geom.Ellipse2D.Double;
 import java.awt.geom.Line2D.Double;
 import java.awt.geom.Rectangle2D.Double;
 
 public class Stift
 {
   protected BasicStroke hatStroke;
   protected Bildschirm kenntPrivatschirm;
   protected static final int NORMALMODUS = 0;
   protected static final int RADIERMODUS = 1;
   protected static final int WECHSELMODUS = 2;
   protected double zStiftH = 0.0D; protected double zStiftV = 0.0D;
   protected boolean zHoch = true;
   protected double zWinkel = 0.0D;
   protected int zSchreibModus = 0;
 
   public Stift()
   {
     this.kenntPrivatschirm = Bildschirm.topFenster;
     this.hatStroke = new BasicStroke(1.0F, 0, 0);
 
     setzeStandard();
   }
 
   public Stift(Fenster pFenster)
   {
     this.kenntPrivatschirm = pFenster;
     this.hatStroke = new BasicStroke(1.0F, 0, 0);
 
     setzeStandard();
   }
 
   public void bewegeBis(double pH, double pV)
   {
     if (!this.zHoch)
       zeichneLinie(pH, pV, this.zStiftH, this.zStiftV);
     this.zStiftH = pH;
     this.zStiftV = pV;
   }
 
   public void bewegeUm(double pDistanz)
   {
     double w = this.zWinkel * 3.141592653589793D / 180.0D;
     double x = this.zStiftH + pDistanz * Math.cos(w);
     double y = this.zStiftV - pDistanz * Math.sin(w);
     if (!this.zHoch)
       zeichneLinie(this.zStiftH, this.zStiftV, x, y);
     this.zStiftH = x;
     this.zStiftV = y;
   }
 
   public void dreheBis(double pWinkel)
   {
     this.zWinkel = pWinkel;
     while (this.zWinkel < 0.0D)
       this.zWinkel += 360.0D;
     while (this.zWinkel >= 720.0D)
       this.zWinkel -= 360.0D;
   }
 
   public void dreheZu(double pWohinH, double pWohinV)
   {
     if ((pWohinH != this.zStiftH) || (pWohinV != this.zStiftV))
     {
       if (pWohinH == this.zStiftH) {
         if (pWohinV > this.zStiftV)
           this.zWinkel = 270.0D;
         else
           this.zWinkel = 90.0D;
       }
       else if (pWohinV == this.zStiftV) {
         if (pWohinH > this.zStiftH)
           this.zWinkel = 0.0D;
         else
           this.zWinkel = 180.0D;
       }
       else if (pWohinH > this.zStiftH) {
         this.zWinkel = (Math.atan((pWohinV - this.zStiftV) / (this.zStiftH - pWohinH)) * 180.0D / 3.141592653589793D);
       }
       else
       {
         this.zWinkel = (Math.atan((pWohinV - this.zStiftV) / (this.zStiftH - pWohinH)) * 180.0D / 3.141592653589793D + 180.0D);
       }
     }
 
     while (this.zWinkel < 0.0D)
       this.zWinkel += 360.0D;
     while (this.zWinkel >= 720.0D)
       this.zWinkel -= 360.0D;
   }
 
   public void dreheUm(double pWinkel)
   {
     this.zWinkel += pWinkel;
     while (this.zWinkel < 0.0D)
       this.zWinkel += 360.0D;
     while (this.zWinkel >= 720.0D)
       this.zWinkel -= 360.0D;
   }
 
   public void schreibeText(String pText)
   {
     Graphics2D g = get2DGraphics(this.kenntPrivatschirm.g());
     if (g != null)
     {
       setzeZustand(g);
       g.drawString(pText, (int)this.zStiftH, (int)this.zStiftV);
       this.zStiftH += g.getFontMetrics().stringWidth(pText);
     }
   }
 
   public void schreibeText(char pZeichen)
   {
     schreibeText("" + pZeichen);
   }
 
   public void schreibeZahl(int pZahl)
   {
     schreibeText("" + pZahl);
   }
 
   public void schreibeZahl(double pZahl)
   {
     schreibeText("" + pZahl);
   }
 
   public void hoch()
   {
     this.zHoch = true;
   }
 
   public void runter()
   {
     this.zHoch = false;
   }
 
   public boolean istUnten()
   {
     return !this.zHoch;
   }
 
   public void normal()
   {
     this.zSchreibModus = 0;
   }
 
   public void radiere()
   {
     this.zSchreibModus = 1;
   }
 
   public void wechsle()
   {
     this.zSchreibModus = 2;
   }
 
   public double hPosition()
   {
     return this.zStiftH;
   }
 
   public double vPosition()
   {
     return this.zStiftV;
   }
 
   public double winkel()
   {
     return this.zWinkel;
   }
 
   protected void zeichneLinie(double x1, double y1, double x2, double y2)
   {
     Graphics2D g = get2DGraphics(this.kenntPrivatschirm.g());
     if (g != null)
     {
       setzeZustand(g);
       g.draw(new Line2D.Double(x1, y1, x2, y2));
     }
   }
 
   public void zeichneRechteck(double pBreite, double pHoehe)
   {
     Graphics2D g = get2DGraphics(this.kenntPrivatschirm.g());
     if (g != null)
     {
       setzeZustand(g);
       g.draw(new Rectangle2D.Double(this.zStiftH, this.zStiftV, pBreite, pHoehe));
     }
   }
 
   public void zeichneKreis(double pRadius)
   {
     Graphics2D g = get2DGraphics(this.kenntPrivatschirm.g());
     if (g != null)
     {
       setzeZustand(g);
       g.draw(new Ellipse2D.Double(this.zStiftH - pRadius, this.zStiftV - pRadius, 2.0D * pRadius, 2.0D * pRadius));
     }
   }
 
   private void setzeStandard()
   {
     this.zStiftH = 0.0D;
     this.zStiftV = 0.0D;
     this.zHoch = true;
     this.zWinkel = 0.0D;
     normal();
   }
 
   protected void setzeZustand(Graphics2D g)
   {
     if (this.zSchreibModus == 1)
     {
       g.setPaint(this.kenntPrivatschirm.hintergrundfarbe());
       g.setPaintMode();
     }
     else if (this.zSchreibModus == 0)
     {
       g.setPaint(Color.black);
       g.setPaintMode();
     }
     else
     {
       g.setPaint(Color.black);
       g.setXORMode(this.kenntPrivatschirm.hintergrundfarbe());
     }
     g.setFont(Schrift.STANDARDSCHRIFT);
   }
 
   protected Graphics2D get2DGraphics(Graphics g)
   {
     Graphics2D g2d = (Graphics2D)g;
     if (g2d != null)
       g2d.setStroke(this.hatStroke);
     return g2d;
   }
 
   public void gibFrei()
   {
   }
 }

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMEreignis.jar
 * Qualified Name:     sum.ereignis.Stift
 * JD-Core Version:    0.6.0
 */