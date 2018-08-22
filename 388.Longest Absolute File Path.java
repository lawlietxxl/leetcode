//这种做法成绩只有 10%
// TODO: 2018/8/22 待优化 

class Solution {
    private int i = 0, result = 0, tNumber = 0;
    public int lengthLongestPath(String input) {
        List<String> files = new LinkedList<>();
        while(i != input.length()){
            String token = nextToken(input);
            if("\n".equals(token)){
                tNumber = 0;
            }else if("\t".equals(token)){
                tNumber++;
            }else if(token.contains(".")){
                files = files.subList(0, tNumber);
                files.add(token);
                int tmpResult = compute(files);
                result = result > tmpResult ? result : tmpResult;
            }else{
                files = files.subList(0, tNumber);
                files.add(token);
            }
        }
        return result;
    }

    private String nextToken(String input){
        int j = i;
        String token;
        for(; j < input.length(); j++){
            //这里的输入到底是什么
            if(input.charAt(j) == '\n' || input.charAt(j) == '\t'){
                break;
            }
        }

        if ( i == j ){
            token = input.substring(i, i+1);
            i += 1;
        } else {
            token = input.substring(i, j);
            i = j;
        }

        return token;
    }
    private int compute(List<String> files){
        int sum = 0;
        for(String s : files){
            sum += s.length();
        }
        sum += files.size()-1;
        return sum;
    }
}