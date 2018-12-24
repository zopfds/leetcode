package leetcode;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] result = new String[path.length()];
        String[] paths = path.split("/");
        int point = 0;
        for(int i = 0 ; i < paths.length ; i ++ ){
            if(paths[i].equals("..")){
                if(point != 0){
                    point --;
                }
            }else if(paths[i].equals(".")){

            }else if(paths[i].equals("") || paths[i] == null){

            }else{
                result[point++] = paths[i];
            }
        }

        StringBuffer sb = new StringBuffer("");
        for(int i = 0 ; i < point ; i ++){
            if(result[i] == null || result[i].equals("")){
                break;
            }
            sb.append("/");
            sb.append(result[i]);
        }

        String resultS = sb.toString();
        if(resultS.equals("")){
            return "/";
        }
        return resultS;
    }

    public static void main(String[] args){
        System.out.println(new SimplifyPath().simplifyPath("/home/"));
    }
}
