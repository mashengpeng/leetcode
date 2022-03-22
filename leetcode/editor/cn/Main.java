package editor.cn;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();


        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);


        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);


        User user1 = new User(1, list1);
        User user2 = new User(2, list2);
        userList.add(user1);
        userList.add(user2);

        System.out.println(fun(userList, 1, 2));
    }


    public static int fun(List<User> list, int a, int b){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == a){
                list1 = list.get(i).getList();
            }else if(list.get(i).getId() == b){
                list2 = list.get(i).getList();
            }
        }
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < list1.size(); i++) {
            set.add(list1.get(i));
        }
        for (int i = 0; i < list2.size(); i++) {
            if(set.contains(list2.get(i))){
                ans++;
            }
        }
        return ans;
    }

    class abc{

    }

}

class User{
    int id;
    List<Integer> list;

    public int getId(){
        return id;
    }

    public List<Integer> getList(){
        return list;
    }


    public User(int id, List<Integer> list){
        this.id = id;
        this.list = list;
    }

    public void set(int id){
        this.id = id;

    }
}
