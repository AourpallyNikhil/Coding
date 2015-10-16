
public class TailQuickSort {

	
	public static void swap(int arr[], int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static int partition(int a [], int first, int last){
		int wall = first;
		int pivot = last;
		
		for(int i = first; i <= last; i++){
			if(a[i] < a[pivot]){
				swap(a, i, wall);
				wall++;
			}			
		}
		swap(a,pivot, wall);
		
		return wall;
	}
	
	public static void TailQuickSort(int a[], int first, int last){	
		while(first < last){
			int pivotIndex = partition(a, first, last);
			TailQuickSort(a, first, pivotIndex - 1);
			first = pivotIndex + 1;
		}
	}
	
	public static void main(String []args){
		int a [] = {5,4,3,1,7,8,9,10};
		int firstIndex = 0;
		int lastIndex = a.length - 1;
		TailQuickSort(a, firstIndex, lastIndex);
		for(int each :a ){
			System.out.print(each+" ");
		}
	}
}
 ============================================================================
" Netrw Directory Listing                                        (netrw v140)
"   /Users/nikhil/Downloads
"   Sorted by      name
"   Sort sequence: [\/]$,\<core\%(\.\d\+\)\=\>,\.h$,\.c$,\.cpp$,*,\.o$,\.obj$,\.info$,\.swp$,\.bak$,\~$
"   Quick Help: <F1>:help  -:go up dir  D:delete  R:rename  s:sort-by  x:exec
" ============================================================================
../
d3/
hadoop/
.DS_Store
.localized
02-MergeSort-and-Recurrence.ppt
03-QuickSort(1) (1).ppt
03-QuickSort(1).ppt
04-Heaps-and-PriorityQueue.ppt
04-hadoop.ppt
11225632_994518133894528_783105136_n.jpg
140227_Basab_Chatterjee_Resume.doc
16a455d9543e4aaabdcf10f914190aa7_homework2.zip
2-3-trees.pdf
6dfea4040a9841b99413b68c01aeb36c_homework2.zip
7zX_1.7.1.dmg
80e7f5026f78404d8b19149360a6c327_CSE_230.7z
80e7f5026f78404d8b19149360a6c327_CSE_230.zip
921-967-1-PB.pdf
AjtCh2gqLY8_Yp2D-QXJnEpo6lbBXnw-EA0cLlEWeK5h.jpg
Assignment 1.odt
AyushMaheshwari.SoftwareEngineer.pdf
CPT Report_Nikhil Aourpally.docx
Chandana Kanchanapally.pdf
Christina-Wilmot.docx
Communication_networks.zip
DDSCodePhase1.txt
DOC (1).PDF
DOC (5).PDF
DOC.PDF
HariChandanaKanchanapally.pdf
IMG_20151008_210258.jpg
Javier-Perez.pdf
John-Hritz.zip
Jordan-Fox.zip
Jose-Frausto.pdf
Justin-Arispe.pdf
Kurose (respostas).doc
Mars4_5 (1).jar
Mars4_5.jar
MicrosoftProblems.txt
Microsoft_Office_2016_Installer.pkg
Nikhil Aourpally (1).pdf
