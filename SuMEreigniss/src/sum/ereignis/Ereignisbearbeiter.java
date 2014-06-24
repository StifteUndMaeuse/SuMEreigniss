package sum.ereignis;

import java.io.Serializable;

public abstract class Ereignisbearbeiter
  implements Serializable
{
  public void bearbeiteTaste(char pZeichen)
  {
  }

  public void bearbeiteMausDruck(int pWoH, int pWoV)
  {
  }

  public void bearbeiteMausLos(int pWoH, int pWoV)
  {
  }

  public void bearbeiteMausBewegt(int pWohinH, int pWohinV)
  {
  }

  public void bearbeiteDoppelKlick(int pWoH, int pWoV)
  {
  }

  public void bearbeiteLeerlauf()
  {
  }

  public void bearbeiteUpdate()
  {
  }

  public void bearbeiteFokusErhalten()
  {
  }

  public void bearbeiteFokusVerloren()
  {
  }

  public void gibFrei()
  {
  }
}

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMEreignis.jar
 * Qualified Name:     sum.ereignis.Ereignisbearbeiter
 * JD-Core Version:    0.6.0
 */