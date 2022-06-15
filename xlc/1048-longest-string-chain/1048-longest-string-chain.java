/*
### My First Aproach
- First sort words by length
- check if current iteration element is in the next element and legth in bigger b 1 | problem
- it is possible that next element have , previous charecter but not in their place. | So what can i do?
- Another problem is, as I am checking is current element is on the enxt element i'm makes this truth that statement , our word chain will start from first element. but it can start from second element too. | problem
- How i am thinking there is also a problem, 

### DP
- I am thinking as in title Longest word mentioned than it can be dp solution
- I cannot think it's dp solution.
- as first of all i cannot think it's bruth force solution
- I can thinnk, but somewhere i my mind, I don't want to think.


*/
class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<String, Integer>();
        Arrays.sort(words, (a,b)->a.length() - b.length());
        int res = 0;
        
        
        /*
        I have to learn core idea of dp,
        - that how it build big solution from small problem
        - Dp concept more broder than what inside me,
        - the aspect i should think when i am doing any dp solution that,
        - how i can make this problem very basic problem, or chunkt it down in a small part.
        - later gradually how can i build big soultion.
        - the most important aspect of problem solving in dp.
        */
        
        for( String word : words){
            int best = 0;
            for (int i=0; i < word.length(); ++i){
                
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            res = Math.max(res, best);
        }
        return res;
        
    }
}