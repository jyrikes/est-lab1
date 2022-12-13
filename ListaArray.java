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
            
            for(int i = this.tamanho-1 ; i > 0; i--){
                    
                    this.elementos[i-1] = this.elementos[i];
                
            }
            this.index --;
            return true;
        }
        else{


            return false;

        }
        
        
    }

    @Override
    public boolean search(int chave) {
        for(int i = 0; i < this.index; i++ ){
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
            System.out.println(this.elementos[i]);
        }
    }

    public static void main(String[] args) {
        ListaArray r = new ListaArray(3);
        boolean a = r.insert(10);
        boolean b = r.insert(-20);
        boolean d =r.insert(30);
        
        //System.out.println(r.search(20));
        System.out.println(r.sucessor(10));
        System.out.println(r.maximum());
        System.out.println(r.minimum());
        //r.mostrarListaArray();
    }
   

}
