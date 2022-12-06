public class ListaArray implements EstruturaDeDados{
    private int[] elementos ;
    private int tamanho;
    private int index;
    private int posBusca;

    public ListaArray(int tamanho) {
        this.tamanho = tamanho;
        this.elementos = new int[tamanho];
        this.index = 0;
        this.posBusca = 0;
    }

    @Override
    public boolean insert(int chave) {

        if(this.index < this.tamanho){
            this.elementos[index] = chave;
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
        
        return 0;
    }

    @Override
    public int maximum() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int sucessor(int chave) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int prodessor(int chave) {
        // TODO Auto-generated method stub
        return 0;
    }
    

    public static void main(String[] args) {
        ListaArray r = new ListaArray(2);
        boolean a = r.insert(10);
        boolean b = r.insert(20);
        boolean c =r.delete(20);
        
        //System.out.println(r.search(20));
        //System.out.println(b);
        System.out.println(r.elementos[0]);
    }
   

}
