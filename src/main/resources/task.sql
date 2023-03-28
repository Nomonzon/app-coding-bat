insert into task(id, name, description, method, category_id, test_id)
values (1, 'sleepIn',
        'The parameter weekday is true if it is a weekday, and the parameter vacation is true if we are on vacation. We sleep in if it is not a weekday or we''re on vacation. Return true if we sleep in.',
        'public class Solution{
public static boolean sleepIn(boolean weekday, boolean vacation) {

}
}', 1, 1);


insert into task(id, name, description, method, category_id, test_id)
values (2, 'monkeyTrouble',
        'We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is smiling. We are in trouble if they are both smiling or if neither of them is smiling. Return true if we are in trouble.',
        'public class Solution{
public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
}
}', 1, 2);
select * from task;
