# Script is responsible for generating a random words, of random size with in the constraints limit
# identified by the user at the beginning of the program, which are the number of words to generate
# and the max word length.
# PS:
#   - Invalid input is not handled.
#   - Maximum number of words / word length is adjusted to be 10^5 maximum.
import os
import random
import string


def random_word(length):
    letters = string.ascii_lowercase
    return ''.join(random.choice(letters) for i in range(length))


def generate_random_words(numberOfWords, maxLenOfWord):
    generated_words = set()
    while len(generated_words) < numberOfWords:
        generated_words.add(random_word(random.randint(1, maxLenOfWord)))
    return list(generated_words)


def export_to_file(toBeExported: list, outputPath = "/IO/generated_words"):
    # print(os.getcwd()) # check your current working directory
    outputFile = open(os.getcwd() + outputPath, "w")
    for word in toBeExported:
        outputFile.write(word + '\n')
    outputFile.close()


def check(number_of_words, max_word_len):
    if number_of_words > pow(10, 5):
        print('Numer Of Words limit is 10^5')
        number_of_words = pow(10, 5)
    if max_word_len > pow(10, 5):
        print('Max word length = 10^5')
        max_word_len = pow(10, 5)
    return number_of_words, max_word_len


def run():
    os.system('cls')
    print('\t\t\t------ Words Random Generator ------\n')
    print('Enter number of words to be generated, and the maximum length for a word separated by a space:')
    number_of_words, max_word_len = map(int, input().split(' '))
    number_of_words, max_word_len = check(number_of_words, max_word_len)
    print(f'User requested to generate {number_of_words} words with a maximum length of {max_word_len} characters.')
    export_to_file(generate_random_words(number_of_words, max_word_len))
    print('Generated successfully, file can be found in the IO directory.')


run()
