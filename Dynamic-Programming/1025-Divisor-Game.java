class Solution {
    public int[] winChance;
    public int[] factorsOfN;
    public int nOfFactors = 0;
    
    public boolean divisorGame(int N) {
        winChance = new int[N];
        factorsOfN = new int[N];
        
        for(int i = 0; i < N; i++) {
            winChance[i] = -1;
            
            if(i > 0 && i < N && N%i == 0) {
                factorsOfN[nOfFactors] = i;
                nOfFactors++;
            }
        }
        
        boolean result = game(true, N, 1);
        
        // DEBUG START
        System.out.println("[DEBUG divisorGame]\nN = " + N + "\nFactors of N :");
        
        for(int i = 0; i < nOfFactors; i++) {
            System.out.printf("%d ", factorsOfN[i]);
        }
        
        System.out.println("\nWin Chance array :");
        
        for(int i = 0; i < N; i++) {
            System.out.printf("%d ", winChance[i]);
        }
        
        System.out.println();
        //DEBUG STOP
        
        return result;
    }
    
    public boolean game(boolean isAliceMove, int N, int x) {
        // DEBUG START
        System.out.println("[DEBUG game]\nN = " + N + "\nX = " + x + "\nisAliceMove = " + isAliceMove);
        //DEBUG STOP
        
        if(isAliceMove && N-x < 1) {
            return false;
        }
        
        if(isAliceMove && N-x == 1) {
            return true;
        }
        
        if(!isAliceMove && N-x < 1) {
            return true;
        }
        
        if(!isAliceMove && N-x == 1) {
            return false;
        }
        
        if(winChance[N-x] != -1) {
            return (winChance[N-x] == 1);
        }
        
        
        int i = 0;
        boolean aliceWin = false;
        
        while(factorsOfN[i] <= (N-x) && i < nOfFactors) {
            aliceWin = game(!isAliceMove, N, x+factorsOfN[i]);
            
            if(aliceWin) {
                winChance[N-x] = 1;
                return true;
            }
            
            i++;
        }
        
        winChance[N-x] = 0;
        return false;
    }
}
