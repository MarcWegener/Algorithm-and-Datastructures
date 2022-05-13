import javax.swing.*;

public class HashApp {

	public static void main(String args[]) {
		final int B = 5;
		String menue = "Eingabe\n";
		menue += " 1) Element einfuegen\n";
		menue += " 2) Element suchen\n";
		menue += " 3) Zelle loeschen\n";
		menue += " 4) Laenge der Liste von Korb k\n";
		menue += " 5) Liste von Korb k ansehen\n";
		menue += " 6) Laenge der Listen von allen Koerben\n";
		menue += " 7) Listen zufaellig fuellen\n";
		String ausgabe = "";
		Liste hashTabelle[];
		hashTabelle = new Liste[B];
		for (int i = 0; i < B; i++)
			hashTabelle[i] = new Liste();
		while (true) {
			String menueeingabe = JOptionPane.showInputDialog(menue);
			if (menueeingabe == null)
				break;
			String dialogEingabe;
			if (menueeingabe.equals("1")) {
				dialogEingabe = JOptionPane.showInputDialog("Datenstring?");

				int h = hashTabelle[0].hashFunktion(dialogEingabe, B); // Welcher Korb?
				boolean existsInHashtable = false;
				for (int j = 1; j <= hashTabelle[h].laenge(); j++) {
					if (hashTabelle[h].inhalt(j).equals(dialogEingabe)) {
						ausgabe = "Element in Korb " + h + " gefunden, daher nicht eingefuegt";
						existsInHashtable = true;
					}
					break;
				}
				if (!existsInHashtable) {
					hashTabelle[h].einsetzenAnfang(dialogEingabe);
					ausgabe = "Eingabe eingefuegt in bucket " + h;
				}
				JOptionPane.showMessageDialog(null, ausgabe);
			}
			if (menueeingabe.equals("2")) {
				dialogEingabe = JOptionPane.showInputDialog("Welches Element soll gesucht werden?");
				ausgabe = "Element nicht gefunden!";

				int such = hashTabelle[0].hashFunktion(dialogEingabe, B);
				for (int j = 1; j <= hashTabelle[such].laenge(); j++) {
					if (hashTabelle[such].inhalt(j).equals(dialogEingabe)) {
						ausgabe = "Element in Korb " + such + " gefunden an der Listenstelle " + j;
						break;
					}
				}

				JOptionPane.showMessageDialog(null, ausgabe);

				// ...
			}
			if (menueeingabe.equals("3")) {
				dialogEingabe = JOptionPane.showInputDialog("Welches Element soll geloescht werden?");
				ausgabe = "Element nicht gefunden!";
				
				int loesch = hashTabelle[0].hashFunktion(dialogEingabe,B);
				for (int j = 1; j <= hashTabelle[loesch].laenge(); j++) {
					if (hashTabelle[loesch].inhalt(j).equals(dialogEingabe)) {
						hashTabelle[loesch].loesche(j);
						ausgabe = "Element in Korb " + loesch + " gelöscht an der Stelle: " + j;
						break;
					}
				}
				JOptionPane.showMessageDialog(null, ausgabe);
			
			}
			if (menueeingabe.equals("4")) {
				dialogEingabe = JOptionPane.showInputDialog("Von welchem Korb soll die Laenge angezeigt werden?");
				ausgabe = "";
				int k = Integer.parseInt(dialogEingabe);
				int l = hashTabelle[k].laenge();
				ausgabe = "Liste hat Laenge " + l;
				JOptionPane.showMessageDialog(null, ausgabe);
			}
			if (menueeingabe.equals("5")) {
				dialogEingabe = JOptionPane.showInputDialog("Von welchem Korb sollen die Elemente ausgegeben werden?");
				ausgabe ="";
				int s = Integer.parseInt(dialogEingabe);
				if (s > B-1 || s < 0) {
					ausgabe = ("Bitte einen Wert zwischen 0 und 4 eingeben.");
				} else {

					ausgabe+=("Liste der Elemente: \n");
					for(int j = 1; j <= hashTabelle[s].laenge(); j++) {
						ausgabe+=("Element " + j + " " + hashTabelle[s].inhalt(j)+"\n");

					}
					
				}
				JOptionPane.showMessageDialog(null, ausgabe);

				// ...
			}
			if (menueeingabe.equals("6")) {
				ausgabe = "";
				for (int i = 0; i < hashTabelle.length; i++) {
					ausgabe+=("Laenge der Liste von Bucket " + i + " " + hashTabelle[i].laenge()+"\n");
					
				}
				
				JOptionPane.showMessageDialog(null,ausgabe);
			}
			
			if (menueeingabe.equals("7")) {
				dialogEingabe = JOptionPane.showInputDialog("Anzahl?");
				ausgabe = "";
				int zahl = Integer.parseInt(dialogEingabe);
				for (int j = 1; j <= zahl; j++) {
					String s = "";
					int laenge = (int) ((Math.random() * 8) + 3); //Größe 3 - 10 Zeichen
					for (int k = 1; k <= laenge; k++) {
						char zufall = (char) ((Math.random() * 26) + 65); // Groß A bis Groß Z
						s += zufall;
					}
					int h = hashTabelle[0].hashFunktion(s, B); // Welcher Korb?
					hashTabelle[h].einsetzenAnfang(s);
				}
			}
		}
	}
}
