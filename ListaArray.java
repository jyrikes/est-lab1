import java.nio.channels.InterruptibleChannel;

public class ListaArray implements EstruturaDeDados{
    private int[] elementos ;
    private int tamanho;
    private int index;
    private int posBusca;
    private int max;
    private int min;

    public ListaArray(int tamanho) {
        this.tamanho = tamanho;
        this.elementos = new int[tamanho];
        this.index = 0;
        this.posBusca = 0;
        this.max = 0 ;
        this.min = 0;
      
    }

    @Override
    public boolean insert(int chave) {

        if(this.index < this.tamanho){
            this.elementos[index] = chave;
            if(index == 0){
                this.min = chave;
            }
            if(this.max < chave){
                this.max = chave;
            }

            if(this.min > chave){
                this.min = chave;
            }

            this.index = index + 1;
            return true;
        }
        else{
            return false;
        }   
        
    }

    @Override
    public boolean delete(int chave) {
        
        if(this.search(chave)){
            int indiceBusca = this.posBusca;
            // System.out.println(indiceBusca);
            int i =this.tamanho -1;
            
            while( i > indiceBusca){
                int correcao = ((this.tamanho-1) - (i-indiceBusca));
                
                if(this.tamanho -1 == i){
                    correcao = 0;   
                    
                }
                else{
                    correcao = correcao -1;
                }
                int aux = indiceBusca +1;
                this.elementos[indiceBusca + correcao] = this.elementos[aux+correcao];
                
                //System.out.println( correcao);


            

                i--;
               

            }
            this.index --;
            this.tamanho --;
            this.atl_min_max();
           

                  if(chave == this.max || chave == this.min){
                    for(int j = 0; j < this.index; j++ ){
                        if(this.max < this.elementos[j]){
                            this.max = this.elementos[j];
                        }
                        if(this.min > this.elementos[j]){
                            this.min = this.elementos[j];
                        }
                    }

                  }
           
            
            
            return true;
        }
        else{
           return false;
        }
        
        
    }

    @Override
    public boolean search(int chave) {
        for(int i = 0; i < this.index; i++ ){
            if(this.max < this.elementos[i]){
                this.max = this.elementos[i];
            }
            if(this.min > this.elementos[i]){
                this.min = this.elementos[i];
            }
            if(chave == this.elementos[i]){
                this.posBusca = i;

                return true;
            }
        }
        return false;
    }

    @Override
    public int minimum() {
        
        return this.min;
    }

    @Override
    public int maximum() {

        return this.max;
    }
    private void atl_min_max(){
        this.max = Integer.MIN_VALUE;
        this.min = Integer.MAX_VALUE;
        for(int i =0 ; i <this.index; i++){
            if(this.max < this.elementos[i]){
                this.max = this.elementos[i];
            }
            if(this.min > this.elementos[i]){
                this.min= this.elementos[i];
            }
        }
    }

    @Override
    public int sucessor(int chave) {
        if(this.search(chave) && this.posBusca < this.index){
            return this.elementos[this.posBusca +1];

        }
        return 0;
    }

    @Override
    public int prodessor(int chave) {
        if(this.search(chave) && this.posBusca < this.index){
            return this.elementos[this.posBusca -1];

        }
        return 0;
       
    }
    public void mostrarListaArray(){
        for(int i = 0 ; i < this.index ; i++){
            System.out.print(this.elementos[i]);
        }
    }

    public static void main(String[] args) {
        ListaArray r = new ListaArray(8);
        boolean a = r.insert(1);
        boolean b = r.insert(2);
        boolean d =r.insert(3);
        boolean e =r.insert(4);
        boolean f =r.insert(5);
        boolean g =r.insert(6);
        boolean h =r.insert(7);
        boolean j =r.insert(8);
        r.mostrarListaArray();
        System.out.println(r.max);
        r.delete(8);
        r.delete(8);

        
        //System.out.println(r.search(20));
        System.out.println("\n");
         r.mostrarListaArray();
        // System.out.println(r.tamanho);
        System.out.println("\n");
         System.out.println(r.max);
         r.delete(1);
         System.out.println("\n");
         System.out.println(r.min);
    }
   

}
