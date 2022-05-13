import java.util.Arrays;

import javax.swing.JOptionPane;

public class HashOpen {
	static final int B = 5, EMPTY = 0, OCCUPIED = 1, DELETED = 2;
	static int[] tagArray = new int[B];
	static String[] hashTable = new String[B];
	static int size = 0;

	public static void main(String[] args) {
		
		
		
		for (int i : tagArray) {
			tagArray[i] = EMPTY;
		}
		String menue = "Eingabe\n";
		menue += " 1| Element einfuegen\n";
		menue += " 2| Element suchen\n";
		menue += " 3| Zelle loeschen\n";
		String ausgabe = "";

		while (true) {
			String menueeingabe = JOptionPane.showInputDialog(menue);
			if (menueeingabe == null)
				break;
			String dialogEingabe;
			if (menueeingabe.equals("1")) {
				ausgabe = "";
				dialogEingabe = JOptionPane.showInputDialog("Bitte einen Wert zum Einfügen eintragen: ");
				ausgabe = einfuegen(dialogEingabe);

				JOptionPane.showMessageDialog(null, ausgabe);

			}
			if (menueeingabe.equals("2")) {
				dialogEingabe = JOptionPane.showInputDialog("Bitte einen Wert zum Suchen eintragen: ");
				int e = searchIndex(dialogEingabe);
				ausgabe = "" + e;
				JOptionPane.showMessageDialog(null, ausgabe);

			}
			if (menueeingabe.equals("3")) {
				dialogEingabe = JOptionPane.showInputDialog("Welche Zelle soll geloescht werden?");
				ausgabe = "";
				ausgabe = remove(dialogEingabe);

				JOptionPane.showMessageDialog(null, ausgabe);

			}
			System.out.println("Zustand HashTabelle:");
			System.out.println("tagArray \t" + Arrays.toString(tagArray));
			System.out.println("bucketArray \t" + Arrays.toString(hashTable));
			System.out.println("*******************************************");
		}

	}

	public static String einfuegen(String eingabe) {

		if (size == B) {
			return "Hashtabelle ist voll";
		}
		
		int u = searchIndex(eingabe);
		
		if(u >= 0) return "Schluessel ist bereits vorhanden und kann nicht eingefügt werden!";
		
		//erfolglose Suche (searchIndex liefert -1) und der Wert wird an der naechstgelegenen nicht belegten Stelle eingefügt
		
		int k = hashIndex(eingabe);
		int i = k;
		int j = 1;
		while (tagArray[i] == OCCUPIED) {
			i = (k - (j++)) % B;
			if (i < 0) {
				i += B;
			}
			
		}
			tagArray[i] = OCCUPIED;
			hashTable[i] = eingabe;
			size++;
			return "Eingabe " + eingabe + " an Stelle " + i + " eingefügt";
		
	}

	public static int searchIndex(String eingabe) {
		int k = hashIndex(eingabe);
		int i = k;
		int j = 1;
		while (tagArray[i] != EMPTY && !hashTable[i].equals(eingabe) && j <= B) {
			i = (k - (j++)) % B;
			if (i < 0) {
				i += B;
			
			}
		}
		if (tagArray[i] == OCCUPIED && hashTable[i].equals(eingabe))
			return i;
		

		return -1;
	}

	public static String remove(String eingabe) {
		int i = searchIndex(eingabe);
		if (i >= 0) {
			if (tagArray[i] == OCCUPIED && hashTable[i].equals(eingabe)) {
				tagArray[i] = DELETED;
				size--;
				return eingabe + " wurde an Stelle " + i + " gelöscht.";

			} else {
				return "Eingabe konnte nicht gelöscht werden";
			}
		} else {
			//Suche erfolglos (searchIndex liefert -1), also kann nicht gelöscht werden.
			return "Eingabe konnte nicht gelöscht werden, da " + eingabe + " nicht gefunden wurde.";
		}

	}

	public static int hashIndex(String eingabe) {
		/*Bei diesem Beispiel sollte beachtet werden, dass Value gleichzeitig auch Key ist.
		  Daher die Verwendung der Methode hashCode() von der Klasse Object*/
		int hash = eingabe.hashCode() % B;
		if (hash < 0)
			hash += B;
		return hash;

	}

}
