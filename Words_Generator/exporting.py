import os


def export_to_file(toBeExported: list, outputPath = ''):
    # print(os.getcwd()) # check your current working directory
    outputFile = open(os.getcwd() + "/testcases/" + outputPath, "w")
    for word in toBeExported:
        outputFile.write(word + '\n')
    outputFile.close()
