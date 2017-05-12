	import java.util.Scanner;
	public class Laundry2 {
	static Scanner data = new Scanner (System.in);
	static String nama  [] = new String [100];
	static double berat [] = new double [100];
	static double bayar [] = new double [100];
	static int masuk [] = new int [100];
	static int tanggal[] = new int [100];
	static int tanggalmasuk[] = new int [100];
	static int bulan [] = new int [100];
	static int tahun [] = new int [100];
	static int harga = 2500, top ,tip;
	static double total = 0;
	static String m [] = new String [100];
	static String cari1 [] = new String [100] ;
	static double jujul;
	public static void main (String []args){
		int pilih=0;
		System.out.println("    \n\tSelamat Datang Di Cool Laundry ");
		do{ 
			menu();
			try{
				System.out.print(" Masukan Pilihan Anda : ");
				pilih = data.nextInt();
			}
			catch (NumberFormatException exc){
				System.out.print(" Inputkan Angka !");
			}
		
			switch(pilih){
				case 1 : inputdata(nama,berat,masuk);
				break;
				case 2 : cetak(nama,berat,masuk);
				break;
				case 3 : pendapatan();
				break;
				case 4 : hapus(nama,berat,masuk,bulan,tahun);
				break;
				case 5 : cari(nama); 
				break;
				case 6 : pengurutan() ;
				break;
				case 7 : max() ;
				break;
				case 8 : min() ;
				break;
				case 9 : trans ();
				break ;
				default: System.out.println("");
			}	
		}
		while (pilih!=10) ;
	}
	
	//Menu
	public static void menu(){
		System.out.println("\n =================================== ");
		System.out.println("| 1.  Masukan Data Pelanggan        |");
		System.out.println("| 2.  Cek Daftar Pelanggan          |");
		System.out.println("| 3.  Total Penghasilan             |");
		System.out.println("| 4.  Mengambil Data Pelanggan      |");
		System.out.println("| 5.  Mencari Data Pelanggan        |");
		System.out.println("| 6.  Pengurutan Data Pelanggan     |");
		System.out.println("| 7.  Melihat Data Maksimal         |");
		System.out.println("| 8.  Melihat Data Minimal          |");
		System.out.println("| 9.  Data Yang Sudah Ditransaksi   |");
		System.out.println("| 10. Exit                          |");
		System.out.println(" ===================================\n");
	}
	
	//Cek Kekosongan
	public static boolean cekkosong(){
		boolean kosong;
		if(top==0){
			kosong = true;
		}else{
			kosong = false;
		}
		return kosong;
	}

	
	//Penginputan Data
	public static void inputdata(String nama[],double berat[],int masuk[]){
		top++;
		
		System.out.print(" Nama Pelanggan     : ");
		nama [top] = data.nextLine();
		nama [top] = data.nextLine();
		System.out.print(" Berat Cucian (kg)  : ");
		berat[top] = data.nextDouble();
		do{
		System.out.print(" Tanggal Masuk      : ");
		masuk[top] = data.nextInt();
			if(masuk[top]<0|masuk[top]>31){
				System.out.println("Maaf inputan salah");
				masuk[top]=-1;
			}
			}
		while(masuk[top]<0|masuk[top]>31);
		do{
		System.out.print(" Bulan Masuk        : ");
		bulan[top] = data.nextInt();
			if(bulan[top]<0|bulan[top]>12){
				System.out.println("Maaf inputan salah");
				bulan[top]=-1;
			}
			}
		while(bulan[top]<0|bulan[top]>12);
		System.out.print(" Tahun Masuk        : ");
		tahun[top] = data.nextInt();
		total = total+(harga*berat[top]);
	}
		
	//Pencetakan Data
	public static void cetak(String nama[],double berat[],int masuk[]){
		int i;
		if(cekkosong()){
			System.out.println("\n Daftar kosong. Tidak ada pelanggan");
		}else{
			System.out.println("\n Daftar Customer ");
			for(i=1;i<=top;i++){
				bayar[i] = harga * berat[i];		
				System.out.println(" No "+i);
				System.out.println(" Nama Pelanggan : " + nama[i]);
				System.out.println(" Berat Cucian   : " + berat[i]+ " kg");
				System.out.println(" Tanggal Masuk  : " + masuk[i]+ "-"+ bulan[i]+"-"+tahun[i]);
							tanggalmasuk[i] = masuk[i] + (bulan[i]*30) + (tahun[i]*360) ;
							int tanggalan1 = tanggalmasuk[i] + 3 ;
							int sisa1 = tanggalan1%360 ;
							tahun[i] =(tanggalan1-sisa1)/360 ;
							int	sisa2 = sisa1%30 ;
							bulan[i] =(sisa1-sisa2)/30 ;
							tanggal[i] = sisa2 ;
				System.out.println(" Tanggal Jadi   : " + tanggal[i]+"-"+ bulan[i]+"-"+tahun[i]);
				System.out.println(" Jumlah Bayar   : Rp." + bayar[i]);
			}
		}
	}

	//Pencetakan Jumlah Total
	public static void pendapatan(){
		if(cekkosong()){
			System.out.println("\n Daftar Kosong, Tidak Ada Pelanggan");
		}else{
			System.out.println("\n Total Pendapatan : Rp." + total);
		}
	}


	//Penghapusan Data	
	public static void hapus(String a[],double b[],int c[],int d[] ,int e[]){
		if(cekkosong()){
			System.out.println("\n Daftar Kosong, Tidak Ada Pelanggan");			
		}else{
			tip++ ;
			System.out.print(" Masukan Nama Pelanggan : ");
			cari1[tip]      = data.nextLine();
			cari1[tip]		= data.nextLine();
			
			for(int i=1;i<=top;i++) {
				if(nama[i].equals(cari1[tip])){
					bayar[i]=harga*berat[i]; 
					System.out.println(" Jumlah Yang Harus Dibayar : Rp"+bayar[i]);
					System.out.print(" Jumlah Yang Dibayarkan : Rp");
					double dibayar = data.nextDouble();
					if(dibayar>bayar[i]){ jujul = dibayar - bayar[i];}
					
					else{
							do{System.out.println("Silahkan masukan pembayaran!");
								System.out.print(" Jumlah Yang Dibayarkan : Rp");
					dibayar = data.nextDouble();
					}while(dibayar < bayar[i]);
					}
					jujul = dibayar - bayar[i];
					System.out.println(" Kembalian : Rp"+jujul);
					
					m[i-(i-1)] = nama[i] ;
					for(int j=i;j<=top-1;j++){
						
						a[i] = a[i+1];
						b[i] = b[i+1];
						c[i] = c[i+1];
						d[i] = d[i+1];
						e[i] = e[i+1];							
					}
					System.out.println(" Nama " + cari1[tip] +" Telah Mengambil Barang Laundrynya ");
					top--;
				} 
			}
		}
	}
	
	//Data Transaksi
	public static void trans () {
		for (int i=1 ; i<=tip ; i++) {
			System.out.println ("Data "+i+" Yang Di Transaksi Dengan Nama "+cari1[i]);
		}
	}
		
	//Pencarian Data
	public static void cari(String nama[]){
		System.out.println(" 1. Mencari Dengan Nama ");
		System.out.println(" 2. Mencari Dengan Tanggal ");
		System.out.print(" Masukan Pilihan Anda : ");
		int pilih = data.nextInt();
			
		switch (pilih){
			case 1 : cariNama();
			break ;
			case 2: caritanggal();
			break ;
		}
	}
	
	public static void cariNama () {
		if(cekkosong()){
			System.out.println("\n Daftar Kosong, Tidak Ada Pelanggan");
		}else{
			System.out.print(" Masukan Nama Pelanggan : ");
			String cari = data.nextLine();
			cari		= data.nextLine();
		
			for(int i=1;i<=top;i++) {
				if(nama[i].equals(cari)){
					System.out.println("\n Nama Pelanggan : " + nama[i] + "\n");
					System.out.println(" Berat Cucian    : " + berat[i]+ " kg");
					System.out.println(" Tanggal Masuk  : " + masuk[i]+"-"+ bulan[i]+"-"+tahun[i]);
							tanggalmasuk[i] = masuk[i] + (bulan[i]*30) + (tahun[i]*360) ;
							int tanggalan1 = tanggalmasuk[i] + 3 ; 
							int sisa1 = tanggalan1%360 ;
							tahun[i] =(tanggalan1-sisa1)/360 ;
							int	sisa2 = sisa1%30 ;
							bulan[i] =(sisa1-sisa2)/30 ;
							tanggal[i] = sisa2 ;
					System.out.println(" Tanggal Jadi    : " + tanggal[i]+"-"+ bulan[i]+"-"+tahun[i]);
					System.out.println(" Jumlah Bayar    : Rp." + (harga*berat[i]));
				}
			}
		}
	}
	
	public static void caritanggal () {
		if(cekkosong()){
			System.out.println("\n Daftar Kosong, Tidak Ada Pelanggan");
		}else{
			System.out.print(" Tanggal Masuk : ");
			int cari1 = data.nextInt();
			System.out.print(" Bulan  Masuk  : ");
			int cari2 = data.nextInt();
			System.out.print(" Tahun Masuk   : ");
			int cari3 = data.nextInt();
			int caries = cari1 + (cari2*30) + (cari3*360) ;
			for(int i=1;i<=top;i++) {
				tanggalmasuk[i] = masuk[i] + (bulan[i]*30) + (tahun[i]*360) ;
				if(tanggalmasuk[i]== caries ){
					System.out.println("\n Nama Pelanggan : " + nama[i] + "\n");
					System.out.println(" Berat Cucian    : " + berat[i]+ " kg");
					System.out.println(" Tanggal Masuk   : " + masuk[i]+"-"+ bulan[i]+"-"+tahun[i]);
					tanggalmasuk[i] = masuk[i] + (bulan[i]*30) + (tahun[i]*360) ;
					int tanggalan1 = tanggalmasuk[i] + 3 ; 
					int sisa1 = tanggalan1%360 ;
					tahun[i] =(tanggalan1-sisa1)/360 ;
					int	sisa2 = sisa1%30 ;
					bulan[i] =(sisa1-sisa2)/30 ;
					tanggal[i] = sisa2 ;
					System.out.println(" Tanggal Jadi    : " + tanggal[i]+"-"+ bulan[i]+"-"+tahun[i]);
					System.out.println(" Jumlah Bayar    : Rp." + (harga*berat[i]));
				}
			}
		}
	}
			
			
	//Pencarian Maksimal	
	public static void max (){
		if(cekkosong()){
			System.out.println("\n Daftar kosong, Tidak Ada Pelanggan");
		}else{	
			System.out.println(" 1. Mencari Data Maksimal Dengan Berat ");
			System.out.println(" 2. Mencari Data Maksimal Dengan Total Bayar ");
			System.out.print(" Masukan Pilihan Anda : ");
			int pilih = data.nextInt();
			
			switch (pilih){
				case 1 : maxberat();
				break ;
				case 2: maxbayar() ;
				break ;
			}
		}
	}
	
	
	public static void maxberat() {
		double max =0 ;
		int i = 1 ;
		while (i<=top){
			if(berat[i]>max){
				max = berat[i];
			}
			i++;
		}
		System.out.println(" Barang Laundry Terberat Hari Ini = " + max +" kg ");
	}
	
	public static void maxbayar() {
		for (int j = 1 ; j<=top ; j++){
			bayar[j] = harga * berat[j];
		}
		double max1 =0 ;
		int i = 1 ;
		while (i<=top){
			if(bayar[i]>max1){
				max1 = bayar[i];
			}
			i++;
		}
		System.out.println(" Pembayaran Termahal Hari Ini = " + max1 +" kg ");
	}
	
	//Pencarian Minimal	
	public static void min(){
		if(cekkosong()){
			System.out.println("\n Daftar Kosong, Tidak Ada Pelanggan");
		}else{
			System.out.println(" 1. Mencari Data Minimal Dengan Berat ");
			System.out.println(" 2. Mencari Data Minimal Dengan Total Bayar ");
			System.out.print(" Masukan Pilihan Anda : ");
			int pilih = data.nextInt();
			
			switch(pilih){
				case 1 : minberat();
				break ;
				case 2 : minbayar();
				break ;
			}
		}
	}
	
	public static void minberat(){
		double min = berat[top] ;
		int i = 1 ;
		while (i<=top){
			if(berat[i]<min){
				min = berat[i];
			}
			i++;
		}
		System.out.println(" Barang Laundry Terringan Hari Ini = " + min +" kg ");
	}
	
	public static void minbayar() {
		double min1 = bayar[top] ;
		int i = 1 ;
		while (i<=top){
			for(int j = 1 ; j<=top ; j++){
				bayar[j] = harga * berat[j];
			}
			if(bayar[i]<min1){
				min1 = bayar[i];
			}
			i++;
		}
		System.out.println(" Pembayaran Termurah Hari Ini = " + min1 );
	}
	
	//Mengurutkan Data		
	public static void pengurutan () {
		if(cekkosong()){
			System.out.println("\n Daftar Kosong, Tidak Ada Pelanggan");
		}else{
			System.out.println(" 1. Mengurutkan Dengan Data Berat Barang ");
			System.out.println(" 2. Mengurutkan Dengan Data Tanggal Masuk Barang ");
			System.out.print(" Masukan Pilihan Anda : ");
			int pilih = data.nextInt();
			
			switch (pilih){
				case 1 : mengurutkanberat (nama,berat);
				break ;
				case 2 : mengurutkantanggal (tanggalmasuk,nama,masuk,bulan,tahun);
				break ;
			}
		}
	}
	
	
	public static void mengurutkanberat (String nama1[] , double berat1[]) {
		for(int i=1 ; i<=top ; i++ ){
			for(int j=1 ; j!= i ; j++){
				if(berat1[j] > berat1[j+1]){tukardata1 (j,j+1,nama1);
											tukardata (j,j+1,berat1);
				}
			}
		}
				
		for(int k=1 ; k<=top ;k++){
			System.out.println(" Dengan Berat " + berat1[k] +" kg Dengan Nama "+ nama1[k] );
		}
	}
	
	public static void tukardata (int a , int b ,double A[]) {
		double c = A[a] ;
		A[a]=A[b] ;
		A[b]=c ; 
	}	
	public static void tukardata2 (int a , int b ,int A[]) {
		int c = A[a] ;
		A[a]=A[b] ;
		A[b]=c ; 
	}
	public static void tukardata1 (int a , int b ,String A[]) {
		String c = A[a] ;
		A[a]=A[b] ;
		A[b]=c ; 
	}
	
	public static void mengurutkantanggal (int tanggalmasuk2[],String nama2[],int masuk2[],int bulan2[],int tahun2[]) {
		for(int i=1 ; i<=top ; i++ ){
			tanggalmasuk2[i] = masuk2[i] + (bulan2[i]*30) + (tahun2[i]*360) ;
			for(int j=1 ; j!= i ; j++){
				if(tanggalmasuk2[j] > tanggalmasuk2[j+1]) {tukardata2 (j,j+1,tanggalmasuk2);
														   tukardata1 (j,j+1,nama2);
														   tukardata2 (j,j+1,masuk2);	 
														   tukardata2 (j,j+1,bulan2);
														   tukardata2 (j,j+1,tahun2);
				}
			}
		}
		for(int k=1 ; k<=top ;k++){
			System.out.println(" Dengan Tanggal " + masuk2[k]+"-"+ bulan2[k]+"-"+tahun2[k]+"  Dengan Nama "+ nama2[k] );
		}		
	}
}

