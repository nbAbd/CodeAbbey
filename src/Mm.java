import java.util.*;

public class Mm {

    public static void main(String args[]) {

        String[] mArray = {
                "(w[*])(((-{g}[-])g<<*[/]>t>{^})[x<->](y))",
                "{c}<c>{{^}[[-{u}]u< ><t>](x(h)[w]) f>}[</>[-]+][[g]f]",
                "<^>{b}<v>({{+(e)[(e[f%) <x>]{{^}/}{w< >}}({z}t)]})([ ][d]<y> )",
                "{<[ ]h<y>><<u{[g]u{c}>>u}<{-}<(a)%> ><b>}",
                "{<h>(w)<%[v][<<z>u{a}>[b]g{[f]c}](/)}d>{-}>{^<<c>}",
                "[<^>%<d>]{{{ }{x}*}t}{[^]<<t>d }[h]{+<b>{w}}",
                "f(b(u))([*{u}(%)]<y>b)((*)%)[v]<(b)b(t)>){[((z)]t}<v>(x){t}(%)",
                "[w]}[y]+]<%>{a}[ (g)]<y><><-[[w]d(g)]{/[>",
                "(c)((h)y)< >[<u>%{b}]({d}z[y](-))[]{c}[ <z>]",
                "<+><[a][<%</>>{d[ (z)[^]]<y{h}>}z] +>(+)[u]>",
                "<g></><v>(v[z][d])<x>[v]{a}{}(<a> {h})<y><v>",
                "[{[e]*[a]}]<<[e] <z[ ](+){%}>{{a}[(y)t]f(/{w})}> >[d({a}y)]",
                "[( )<(b)b({f}c< >){u}>[g]< [z]>]{[%]f(^)}( )",
                "[f]((y)w)(x)<w>bd{%}<t>>{d}<<u>a><<{v}>{<(z)*><%>}<^>",
                "[y](+){[h{<a>h})( )(/)[^]{{c{z}}(t]{c}-[d]{h}}}",
                "<(u(/))>[c][{v}[d(v)(a)]+(g)](b<<z>u>){-}",
                "(({u} < >-(-)> ))([u]w[*]{+[ {^}]}(/))[(<w>{u}[z]*)[f](*)y]",
                "((c<%<)d< >{h})[*][(b(x)){*}x<{/{[ ]e}}((t){u{y}}e)> ><v>h< >>][]",
                "<(z){t}<g<e>>[[%]< {f}[(+)d{g}](+)>(x)f{b}]><[t]d>",
                "[](u(g)<(a)[u]h>)<e>({{%}d}z)<g{x[z](g(h))} {< >e}}"};
        Scanner input = new Scanner(System.in);
        char[] mChar;
        //int num_test = input.nextInt();
        //String rows[] = new String[num_test];
        List<Integer> outputs = new ArrayList<>();

        for (int i = 0; i < mArray.length; i++) {
//            rows[i] = input.next();
            String m = mArray[i].replaceAll(" ","");
//             mChar = m.toCharArray();
          //  System.out.print(m);
            boolean check = checkBrackets(m);
            int num = Boolean.compare(check, false);
            outputs.add(num);
        }


        for (Integer output : outputs) {
            System.out.print(output + " ");
        }

    }

    private static boolean checkBrackets(String str){  // ()[([])<{}[](()[]){}<>[]>{}{}({})[<>]]
        if(str.isEmpty()){
            return true;
        }
        str = str.replaceAll(" ","");
        Stack<Character> mStack = new Stack<>();

        for (int i = 0; i < str.length() ; i++) {

            char c = str.charAt(i);
            if(c == ' '){
                continue;
            }

            if(c =='{' || c == '(' || c == '[' || c == '<'){

                mStack.push(c);

            }

            if(c == '}' || c == ')' || c == ']' || c == '>'){

                if(!mStack.isEmpty()){ // if stack is not empty

                    char o = mStack.peek(); // get last in char

                    if(c == '}'){
                        if(o == '{'){
                            mStack.pop();
                        }else{ return false;}
                    }

                    if(c == ']'){
                        if( o == '['){
                        mStack.pop();
                        }else{ return  false;}
                    }
                    if(c == ')'){
                        if(o == '('){
                            mStack.pop();
                        }
                        else{ return false; }
                    }
                    if (c == '>'){
                        if(o == '<'){
                        mStack.pop();
                        }else{ return false;}
                    }
                }else{ // if mStack is empty return false
                    return false;
                }
            }
        }
        return mStack.isEmpty();
    }

}
