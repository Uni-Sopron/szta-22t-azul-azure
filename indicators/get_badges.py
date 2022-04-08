import os
from urllib.request import Request, urlopen

def main():
    os.chdir(os.path.dirname(os.path.realpath(__file__)))
    
    pmd_name = "pmd.svg"
    jacoco_name = "jacoco.svg"
    
    with open("../app/build/reports/pmd/main.xml", "r") as mainFile:
        main_occurencces = mainFile.read().count("</violation>")
    
    
    pmd_url = "https://img.shields.io/badge/PMD%20Errors-{occurences}-{color}.svg?style=plastic&logo=java".format(occurences = main_occurencces if main_occurencces > 0 else "OK", color = "critical" if main_occurencces > 0 else "success")

    req = Request(pmd_url, headers={'User-Agent': 'Mozilla/5.0'})
    pmd_content = urlopen(req).read()
    
    with open("badges/{pmd}".format(pmd = pmd_name), "wb") as pmd_badge:
        pmd_badge.write(pmd_content)
            
            
    with open("../app/build/reports/jacoco/test/html/index.html", "r", encoding='utf-8') as f:
        dom= f.read()
        
    tfoot = dom[dom.find("<tfoot>")+len("<tfoot>"):dom.rfind("</tfoot>")]
    percent_pos = tfoot.find("%")
    percentage = ""
    while(percent_pos >= 0 and tfoot[percent_pos-1]).isdigit():
        percentage += tfoot[percent_pos-1]
        percent_pos -= 1
      
    percentage = int(percentage [::-1])
    
    
    jacoco_url = "https://img.shields.io/static/v1?label=coverage&message={cov_value}&color={color}".format(cov_value = str(percentage)+"%", color = "critical" if percentage < 50 else "success" if percentage > 90 else "yellowgreen")
            
    req = Request(jacoco_url, headers={'User-Agent': 'Mozilla/5.0'})
    jacoco_content = urlopen(req).read()
    
    
    with open("badges/{jacoco}".format(jacoco = jacoco_name), "wb") as jacoco_badge:
        jacoco_badge.write(jacoco_content)

            

    

if __name__ == "__main__":
    main()