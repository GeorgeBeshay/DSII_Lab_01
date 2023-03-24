import random
import exporting
import datetime


def generate_test(numbers_count=200, number_of_testcases=50):
    testcases: str = ''      # the test case code
    for testcase_number in range(number_of_testcases):
        numbers = []
        for i in range(numbers_count):
            numbers.append(random.randint(-10**9, 10**9))
        testcases += '@Test\n'
        testcases += f'public void random_testcase_{testcase_number}()' + '{\n'
        testcases += '// Random testcase generated using python\n'
        testcases += 'RB_Tree<Integer> tree = new RB_Tree<Integer>();\n'
        for number in numbers:
            testcases += f'tree.insert({number});\n'
        numbers.sort()
        numbers_literal: str = 'Integer[] data = {'
        for number in numbers:
            numbers_literal += f'{number}, '
        numbers_literal += f'{numbers_literal[-1]}' + '};\n'
        testcases += numbers_literal
        testcases += 'assertEquals(tree.filter(tree.convert_to_list()), Arrays.asList(data));\n'
        testcases += 'assertTrue(tree.validateTree());\n'
        testcases += 'assertTrue(tree.getHeight() <= 2 * tree.getBlackHeight());\n'
        testcases += f'assertEquals(tree.getSize(), {len(numbers)});\n'
        testcases += '}\n'
        testcases += '\n'
    return testcases


exporting.export_to_file([generate_test()], f"random_testcase_{datetime.datetime.now()}")
