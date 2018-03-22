import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Star_Tree{
	
	String Attributes =""; //Initialize the attributes of the Tree
	int min_sup = 0;
	
	boolean isLeaf; 
	boolean siblings;
	
	ArrayList <Star_Tree> allchildren = new ArrayList<>(); //create an arraylist for the children
	
	//3 Constructors for Star_tree class(Constructor overloading)
	Star_Tree(int m){
		this.min_sup = m;
	}
	
	Star_Tree(String att, int m){
		this.min_sup = m;
		this.Attributes = att;
	}
	
	Star_Tree(){
	}	
}

class StarTable_Dim{
	
	HashMap<Integer, String> Fixed_Acidity = new HashMap<Integer, String>();
	HashMap<Integer, String> Volatile_Acidity = new HashMap<Integer, String>();
	HashMap<Integer, String> Citric_Acid = new HashMap<Integer, String>();
	HashMap<Integer, String> Residual_Sugar = new HashMap<Integer, String>();
	HashMap<Integer, String> chlorides = new HashMap<Integer, String>();
	HashMap<Integer, String> Sulphur_dioxide = new HashMap<Integer, String>();
	HashMap<Integer, String> Total_Sulphur_dioxide = new HashMap<Integer, String>();
	HashMap<Integer, String> Density = new HashMap<Integer, String>();
	HashMap<Integer, String> PhValue = new HashMap<Integer, String>();
	HashMap<Integer, String> Sulphates = new HashMap<Integer, String>();
	HashMap<Integer, String> alcohol = new HashMap<Integer, String>();
	//HashMap<Integer, String> Quality = new HashMap<Integer, String>();
	
}


public class MainProgram {
	
	StarTable_Dim dim = new StarTable_Dim(); //object
	int totalcount = 0;
	
	HashMap<String, Integer> Fixed_Acidity_count = new HashMap<String, Integer>();
	HashMap<String, Integer> Volatile_Acidity_count = new HashMap<String, Integer>();
	HashMap<String, Integer> Citric_Acid_count = new HashMap<String, Integer>();
	HashMap<String, Integer> Residual_Sugar_count = new HashMap<String, Integer>();
	HashMap<String, Integer> chlorides_count = new HashMap<String, Integer>();
	HashMap<String, Integer> Sulphur_dioxide_count = new HashMap<String, Integer>();
	HashMap<String, Integer> Total_Sulphur_dioxide_count = new HashMap<String, Integer>();
	HashMap<String, Integer> Density_count = new HashMap<String, Integer>();
	HashMap<String, Integer> PhValue_count = new HashMap<String, Integer>();
	HashMap<String, Integer> Sulphates_count = new HashMap<String, Integer>();
	HashMap<String, Integer> alcohol_count = new HashMap<String, Integer>();
	//HashMap<String, Integer> Quality_count = new HashMap<String, Integer>();
	
	
	HashMap<String, String> Fixed_Acidity_NI = new HashMap<String, String>();
	HashMap<String, String> Volatile_Acidity_NI = new HashMap<String, String>();
	HashMap<String, String> Citric_Acid_NI = new HashMap<String, String>();
	HashMap<String, String> Residual_Sugar_NI = new HashMap<String, String>();
	HashMap<String, String> chlorides_NI = new HashMap<String, String>();
	HashMap<String, String> Sulphur_dioxide_NI = new HashMap<String, String>();
	HashMap<String, String> Total_Sulphur_dioxide_NI = new HashMap<String, String>();
	HashMap<String, String> Density_NI = new HashMap<String, String>();
	HashMap<String, String> PhValue_NI = new HashMap<String, String>();
	HashMap<String, String> Sulphates_NI = new HashMap<String, String>();
	HashMap<String, String> alcohol_NI = new HashMap<String, String>();
	//HashMap<String, String> Quality_NI = new HashMap<String, String>();
	
	HashMap<Integer, ArrayList<String>> table = new HashMap<Integer, ArrayList<String>>();
	
	HashMap<ArrayList<String>, Integer> reducedTable = new HashMap<ArrayList<String>, Integer>();
	
	public void readFile() {
		
		String filename = "/Users/kaushikkulkarni/Downloads/GlassData.csv";
		String line = null;
		
		try {
				FileReader fileReader = new FileReader(filename);
            
				BufferedReader bufferedReader = new BufferedReader(fileReader);
            
				int index = 0;

				while((line = bufferedReader.readLine()) != null) {
            			String[] arr = line.split(";");
            			index++;
            			if(index > 1){
	            		dim.Fixed_Acidity.put(index-2, arr[0]);
	            		dim.Volatile_Acidity.put(index-2, arr[1]);
	            		dim.Citric_Acid.put(index-2, arr[2]);
	            		dim.Residual_Sugar.put(index-2, arr[3]);
	            		dim.chlorides.put(index-2, arr[4]);
	            		dim.Sulphur_dioxide.put(index-2, arr[5]);
	            		dim.Total_Sulphur_dioxide.put(index-2, arr[6]);
	            		dim.Density.put(index-2, arr[7]);
	            		dim.PhValue.put(index-2, arr[8]);
	            		dim.Sulphates.put(index-2, arr[9]);
	            		dim.alcohol.put(index-2, arr[10]);
	            		//dim.Quality.put(index-2,arr[11]);
            			}
				}
				bufferedReader.close();         		
			}
			catch(FileNotFoundException ex){
				System.out.println(
						"Unable to open file '" + 
								filename + "'"); 
			}
			catch(IOException ex) {
				System.out.println(
						"Error reading file '" 
								+ filename + "'"); 
			}
		}
	
	HashMap<Integer, String> Fixed_Acidity_Iceberg = new HashMap<Integer, String>();
	HashMap<Integer, String> Volatile_Acidity_Iceberg = new HashMap<Integer, String>();
	HashMap<Integer, String> Citric_Acid_Iceberg = new HashMap<Integer, String>();
	HashMap<Integer, String> Residual_Sugar_Iceberg = new HashMap<Integer, String>();
	HashMap<Integer, String> chlorides_Iceberg = new HashMap<Integer, String>();
	HashMap<Integer, String> Sulphur_dioxide_Iceberg = new HashMap<Integer, String>();
	HashMap<Integer, String> Total_Sulphur_dioxide_Iceberg = new HashMap<Integer, String>();
	HashMap<Integer, String> Density_Iceberg = new HashMap<Integer, String>();
	HashMap<Integer, String> PhValue_Iceberg = new HashMap<Integer, String>();
	HashMap<Integer, String> Sulphates_Iceberg = new HashMap<Integer, String>();
	HashMap<Integer, String> alcohol_Iceberg = new HashMap<Integer, String>();
	//HashMap<Integer, String> Quality_Iceberg = new HashMap<Integer, String>();
	
	public HashMap<String, Integer> count (HashMap<Integer, String> mapa, HashMap<String, Integer> mapb){
		int count = 1;
		for(int i=0; i<mapa.size(); i++){
			if(!mapb.containsKey(mapa.get(i))){
				mapb.put(mapa.get(i), count);
			}
			else{
				int t = mapb.get(mapa.get(i));
				mapb.put(mapa.get(i), t+1);
			}
		}
		return mapb;
	}
	
	public void cntUpdate() {
		
		Fixed_Acidity_count = count(dim.Fixed_Acidity, Fixed_Acidity_count);
		Volatile_Acidity_count = count(dim.Volatile_Acidity, Volatile_Acidity_count);
		Citric_Acid_count = count(dim.Citric_Acid, Citric_Acid_count);
		Residual_Sugar_count = count(dim.Residual_Sugar, Residual_Sugar_count );
		chlorides_count = count(dim.chlorides, chlorides_count);
		Sulphur_dioxide_count = count(dim.Sulphur_dioxide, Sulphur_dioxide_count );
		Total_Sulphur_dioxide_count = count(dim.Total_Sulphur_dioxide, Total_Sulphur_dioxide_count );
		Density_count = count(dim.Density, Density_count );
		PhValue_count = count(dim.PhValue, PhValue_count);
		Sulphates_count = count(dim.Sulphates, Sulphates_count);
		alcohol_count = count(dim.alcohol, alcohol_count);
		//Quality_count = count(dim.Quality, Quality_count);
		
	}
	
	public HashMap<String, String> checkIceberg(HashMap<String, Integer> mapa, HashMap<String, String> mapb,int aprioric){
		
		for(Map.Entry<String, Integer> i: mapa.entrySet()){
			if(i.getValue() < aprioric){
				mapb.put(i.getKey(), "*");
			}
		}
		return mapb;
	}

	public void updateNI(int aprioric){
		Fixed_Acidity_NI = checkIceberg(Fixed_Acidity_count, Fixed_Acidity_NI, aprioric);
		Volatile_Acidity_NI =checkIceberg(Volatile_Acidity_count, Volatile_Acidity_NI, aprioric);
		Citric_Acid_NI = checkIceberg(Citric_Acid_count, Citric_Acid_NI, aprioric);
		Residual_Sugar_NI = checkIceberg(Residual_Sugar_count, Residual_Sugar_NI, aprioric);
		chlorides_NI = checkIceberg(chlorides_count, chlorides_NI, aprioric);
		Sulphur_dioxide_NI = checkIceberg(Sulphur_dioxide_count, Sulphur_dioxide_NI, aprioric);
		Total_Sulphur_dioxide_NI = checkIceberg(Total_Sulphur_dioxide_count, Total_Sulphur_dioxide_NI, aprioric);
		Density_NI = checkIceberg(Density_count, Density_NI, aprioric);
		PhValue_NI= checkIceberg(PhValue_count, PhValue_NI, aprioric);
		Sulphates_NI = checkIceberg(Sulphates_count, Sulphates_NI, aprioric);
		alcohol_NI = checkIceberg(alcohol_count, alcohol_NI, aprioric);
		//Quality_NI = checkIceberg(Quality_count, Quality_NI, aprioric);
	}
	
	public HashMap<Integer, String> updateData(HashMap<String, String> mapa, HashMap<Integer, String> mapb){
		for(Map.Entry<String, String> i: mapa.entrySet()){
			String temp = i.getKey();
			for(int j=0; j<mapa.size(); j++){
				if(mapb.get(j) == temp){
					mapb.put(j, "*");
				}
			}
		}
		return mapb;
	}
	
	public void getUpdatedData() {
		
		Fixed_Acidity_Iceberg= dim.Fixed_Acidity;
		Fixed_Acidity_Iceberg = updateData(Fixed_Acidity_NI, Fixed_Acidity_Iceberg);
		Volatile_Acidity_Iceberg = dim.Volatile_Acidity;
		Volatile_Acidity_Iceberg = updateData(Volatile_Acidity_NI, Volatile_Acidity_Iceberg);
		Citric_Acid_Iceberg = dim.Citric_Acid;
		Citric_Acid_Iceberg = updateData(Citric_Acid_NI, Citric_Acid_Iceberg);
		Residual_Sugar_Iceberg= dim.Residual_Sugar;
		Residual_Sugar_Iceberg = updateData(Residual_Sugar_NI,Residual_Sugar_Iceberg);
		chlorides_Iceberg = dim.chlorides;
		chlorides_Iceberg = updateData(chlorides_NI, chlorides_Iceberg);
		Sulphur_dioxide_Iceberg = dim.Sulphur_dioxide;
		Sulphur_dioxide_Iceberg = updateData(Sulphur_dioxide_NI,Sulphur_dioxide_Iceberg);
		Total_Sulphur_dioxide_Iceberg = dim.Total_Sulphur_dioxide;
		Total_Sulphur_dioxide_Iceberg = updateData(Total_Sulphur_dioxide_NI, Total_Sulphur_dioxide_Iceberg);
		Density_Iceberg = dim.Density;
		Density_Iceberg = updateData(Density_NI, Density_Iceberg);
		PhValue_Iceberg = dim.PhValue;
		PhValue_Iceberg = updateData(PhValue_NI,PhValue_Iceberg);
		Sulphates_Iceberg = dim.Sulphates;
		Sulphates_Iceberg = updateData(Sulphates_NI,Sulphates_Iceberg);
		alcohol_Iceberg = dim.alcohol;
		alcohol_Iceberg = updateData(alcohol_NI,alcohol_Iceberg);
		//Quality_Iceberg = dim.Quality;
		//Quality_Iceberg = updateData(Quality_NI, Quality_Iceberg);
		
	}
	
	public void tableCreate(){
		
		for(int i = 0; i<Fixed_Acidity_Iceberg.size(); i++){
			
			ArrayList<String> tmp = new ArrayList<String>();
			tmp.add(Fixed_Acidity_Iceberg.get(i));
			tmp.add(Volatile_Acidity_Iceberg.get(i));
			tmp.add(Citric_Acid_Iceberg.get(i));
			tmp.add(Residual_Sugar_Iceberg.get(i));
			tmp.add(chlorides_Iceberg.get(i));
			tmp.add(Sulphur_dioxide_Iceberg.get(i));
			tmp.add(Total_Sulphur_dioxide_Iceberg.get(i));
			tmp.add(Density_Iceberg.get(i));
			tmp.add(PhValue_Iceberg.get(i));
			tmp.add(Sulphates_Iceberg.get(i));
			tmp.add(alcohol_Iceberg.get(i));
			//tmp.add(Quality_Iceberg.get(i));
			
			table.put(i,tmp);
		}
	}
	
	public void tableReduce(){
		int count = 1;
		
		for(int i=0; i<table.size(); i++){
			if(!(reducedTable.containsKey(table.get(i)))){
				reducedTable.put(table.get(i), count);
			}
			else{
				
				int t = reducedTable.get(table.get(i));
				reducedTable.put(table.get(i), t+1);
			}
		}
	}
	
	public void countTotal(){
		for(Map.Entry<ArrayList<String>, Integer> a : reducedTable.entrySet()){
			int b = a.getValue();
			totalcount = totalcount + b;
			//System.out.println("total Count" + "=" + totalcount);
		}
	}
	
	
	Star_Tree root = new Star_Tree(totalcount);
	
	//check for a child
	public Star_Tree childCheck(Star_Tree root, String s){
		
		ArrayList<Star_Tree> child = root.allchildren;
		//System.out.println("childs" + child);
		
		Star_Tree tmp;
		
		if(!child.isEmpty()){
			for(int i=0; i<child.size(); i++){
				tmp = child.get(i);
				if(tmp.Attributes.equals(s))
					return tmp;
			}
		}		
		return null;
	}
	
	//create a Star tree
	public void starTreeCreate(ArrayList<String> row, int iCount){
		Star_Tree currentNode = root;
		
		for(int i=0; i<row.size(); i++){
			Star_Tree status = childCheck(currentNode, row.get(i));
			if(status == null){
				Star_Tree newNode = new Star_Tree(row.get(i),iCount);
				if(i == row.size()-1){
					newNode.isLeaf = true;
				}
				currentNode.allchildren.add(newNode);
				if(currentNode.allchildren.size() > 1){
					currentNode.siblings = true;
				}
				currentNode = newNode;
				//System.out.println("Child Added");
				}
			else{
				currentNode = status;
				currentNode.min_sup = currentNode.min_sup+1;
				//System.out.println("Root Already Exists");
			}
		}
	}
	
	public void Row(){
		for(Map.Entry<ArrayList<String>, Integer> a : reducedTable.entrySet()){
			starTreeCreate(a.getKey(),a.getValue());
		}
	}
	
	public void deptfFirstSearch(Star_Tree root){
		if(root.allchildren.size()<=0){
			return;
		}
		
		for(int j=0;j<root.allchildren.size();j++){
	    		
	    		deptfFirstSearch(root.allchildren.get(j));
	    		//System.out.println("element of "+ root.Attributes);	
    		//System.out.println(root.allchildren.get(j).min_sup);
	    		  
			
		}	
		return ;
		
	}
	
	public void starCubing(){
		deptfFirstSearch(root);
	}

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		
		long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		
		MainProgram white = new MainProgram();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter condition");
		int aprioric = sc.nextInt();
		sc.close();
		
		
		
		white.readFile();
		white.cntUpdate();
		white.updateNI(aprioric);
		white.getUpdatedData();
		white.tableCreate();
		white.tableReduce();
		white.countTotal();
		white.Row();
		white.starCubing();
//		System.out.println("Star Table");
//	
//		for(Map.Entry<Integer, ArrayList<String>> i : white.table.entrySet()){
//		System.out.print(i.getKey() + " : ");
//		ArrayList<String> t = i.getValue();
//		for(int j=0; j<t.size(); j++){
//			System.out.print(t.get(j)+ " ");
//		}
//		System.out.println();
//		}
	 
		System.out.println();
	   
		System.out.println("Compressed Base Table");
		 System.out.println();
		for(Map.Entry<ArrayList<String>, Integer> a : white.reducedTable.entrySet()){
			
			ArrayList<String> t = a.getKey();
			
			for(int j=0; j<t.size(); j++){
				System.out.print(t.get(j)+ " ");
			}
			
			System.out.println(":=="+ a.getValue());
		}
		
		
//		white.Row();
//		white.starCubing();
		
		long endTime   = System.nanoTime();
		long totalTime = (endTime - startTime)/1000000;
		System.out.println("Total Execution Time = " + totalTime);
		
		long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		long actualMemUsed=(afterUsedMem-beforeUsedMem);
		System.out.println("Memory used = " + actualMemUsed);

	}

}
