import java.util.ArrayList;

public class Tierliste
{
    private ArrayList<Tier> tiere;

    public Tierliste()
    {
        tiere = new ArrayList<>();
    }

    public boolean fuegeHinzu(Tier zootier)
    {
        for (int i = 0; i < tiere.size(); i++)
        {
            if(tiere.get(i).getName() == zootier.getName())
            {
                return false;
            }
        }

        tiere.add(zootier);
        return true;
    }

    public boolean loesche(Tier opfer)
    {
        for (int i = 0; i < tiere.size(); i++)
        {
            if(tiere.get(i).getName() == opfer.getName())
            {
                tiere.remove(i);
                return true;
            }
        }

        return false;
    }

    public String toString()
    {   
        String buffer = "";

        for (Tier crtTier : tiere)
        {
            buffer += crtTier.toString() + " ";
        }

        return buffer;
    }

    public String getNames()
    {   
        String buffer = "";

        for (Tier crtTier : tiere)
        {
            buffer += "Das Tier heißt " + crtTier.getName() + 
                      ", wiegt " + crtTier.getGewicht() + "kg, " + 
                      " wohnt im Zoo " + crtTier.getZoo() + ", ";
                    
            if (crtTier.getClass().getName().equals("Reh"))
            {
                Reh crtReh = (Reh)crtTier;
                buffer += "isst gerne " + crtReh.getLieblingspflanze() + ", ist ein Reh und hat zur Zeit " + 
                          (crtReh.hasGeweih() ? "ein Geweih" : "kein Geweih");
            }
            else if (crtTier.getClass().getName().equals("Hase"))
            {
                Hase crtHase = (Hase)crtTier;
                buffer += "isst gerne " + crtHase.getLieblingspflanze() + 
                          ", ist ein Hase und hat " + crtHase.getOhrenlaenge() + 
                          "cm lange Ohren";
            }
            else if (crtTier.getClass().getName().equals("Wolf"))
            {
                Wolf crtWolf = (Wolf)crtTier;
                buffer += "ist " + (crtWolf.istJeager() ? "ein Jäger" : "kein Jäger") + " und ist ein Wolf";
            }
            else if (crtTier.getClass().getName().equals("Hyaene"))
            {
                Wolf crtHyaene = (Wolf)crtTier;
                buffer += "ist " + (crtHyaene.istJeager() ? "ein Jäger" : "kein Jäger") + " und ist eine Hyäne";
            }
        }

        return buffer;
    }
}