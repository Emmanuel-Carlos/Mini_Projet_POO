package core;

import java.util.ArrayList;


public class Repertoire
{
    public ArrayList<Contact> liste_contacts;

    public Repertoire(ArrayList<Contact> liste_contacts)

    {
        this.liste_contacts=liste_contacts;
    }

    public void ajouter_contact(Contact contact)
    {
        liste_contacts.add(contact);
    }

    public void supprimer_contact(Contact contact)
    {
        liste_contacts.remove(contact);
    }

    public void modifier_contact(Contact oldContact,Contact newContact)
    {
        liste_contacts.set(liste_contacts.indexOf(oldContact),newContact );

    }

    public boolean rechercher_contact(Contact contact)
    {
        for (Contact listeContact : liste_contacts) {
            if (listeContact.equals(contact))
                return true;
        }
        return false;
    }
}
