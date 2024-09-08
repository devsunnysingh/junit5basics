Create instance of the class in the test method
Set up inputs
Execute the code you want to test
Verifying the result is what we expect  

```

public class MathUtils {
    public int add(int a, int b){
        return a+b;
    }
}

```

test case below:
```
 @Test
    public void testAdd(){
        MathUtils mathUtils=new MathUtils();
        int expected=2;
        int result=mathUtils.add(1,1);
        assertEquals(result,expected);

    }

```
Types of Asserts
1. **assertEquals(expected, actual):** Asserts that expected and actual are equal.
2. **assertArrayEquals(expectedArray, actualArray):** Verify each item in arrays are equal in the right position.
3. **assertIterableEquals(expectedArray, actualArray):** Verifies each item in the iterable are equal in the corresponding positions.

@BeforeAll and @Afterall needs to be static in order to work even without instances


