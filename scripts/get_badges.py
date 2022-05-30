import os
from urllib.request import Request, urlopen

def main():
    os.chdir(os.path.dirname(os.path.realpath(__file__)))
    
    pmd_name = "pmd.svg"
    
    with open("../app/build/reports/pmd/main.xml", "r") as mainFile:
        main_occurencces = mainFile.read().count("</violation>")
    
    
    pmd_url = "https://img.shields.io/badge/PMD%20Errors-{occurences}-{color}.svg?style=plastic&logo=java".format(occurences = main_occurencces if main_occurencces > 0 else "OK", color = "critical" if main_occurencces > 0 else "success")

    req = Request(pmd_url, headers={'User-Agent': 'Mozilla/5.0'})
    pmd_content = urlopen(req).read()
    
    with open("../.github/badges/{pmd}".format(pmd = pmd_name), "wb") as pmd_badge:
        pmd_badge.write(pmd_content)
 

if __name__ == "__main__":
    main()