public class Main{
    public static void main(String []args){
        
        int count=0;
        for(int i=1;i<=2020;i++){
            int n=i;
            
            while(n!=0){
                if(n%10==2){
                    count+=1;
                }
                n/=10;
            }
        }
        System.out.println(count);
    }
}