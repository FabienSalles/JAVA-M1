package FileSystemJ;

import fr.p10.miagem1.ppo.td1.File.OpenMode;

public class TestFile {
	
	public static void main(String args[]) {
		SimpleFile f1 = new SimpleFile("f1.txt","bob");
		f1.open(OpenMode.READ);
		System.out.println(f1.write("interdit")); // false
		System.out.println(f1.open(OpenMode.WRITE)); // false
		f1.close();
		f1.open(OpenMode.WRITE);
		f1.write("contenu");
		System.out.println(f1.read()); // null
		f1.close();
		System.out.println(f1.read()); // null
		f1.open(OpenMode.READ);
		System.out.println(f1.read()); // contenu
		System.out.println();
		//
		SimpleFile f2 = new SimpleFile("f2.txt","bob");
		Directory d1 = new Directory("d1","bob");
		d1.add(f1); d1.add(f2); // pas top, on voudrait passer par write uniquement. Mettre add private ...
		Directory d2 = new Directory("d2","homer");
		d2.add(f2); d2.add(d1);
		System.out.println(d2+"\n"); // 1 sous r�pertoire + 1 fichiers. pas top, passer par read ...
		//
		d2.open(OpenMode.APPEND); d2.write("f3.txt"); d2.close(); 
		d2.open(OpenMode.READ); System.out.println(d2.read()+"\n"); // 1 sous-r�pertoire + 2 fichiers
		d2.close(); d2.open(OpenMode.WRITE); d2.write("f4.txt"); d2.close();
		d2.open(OpenMode.READ); System.out.println(d2.read()+"\n"); // 1 fichier seulement
	}

}
