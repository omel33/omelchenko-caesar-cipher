Steps
0: when launch: output instruction (app description, input arguments and allowed symbols)
1: identify/validate parameters of request: encrypt/decrypt/brute-force (stop app if input is incorrect), filepath
2: select strategy for input
3a: run encrypt
3b: run decrypt
3c: run brute force

4a(encrypt):

    - validate input data file from path
    - ask user for encrypt key
    - save into file 
4b(decrypt):

    - verify file exists
    - decrypt from file
    - ouput to file with prefix
4c(BF):

    - verify file exists
    - use console to interact with user? to verify decrypted
    - ask for the key/shift (1-2-...) and output decrypted into console
    - if user approves output then save in the file and exit
    
step 2 створити клаас та метод котрий буде зчитувати файл та перезаписувати згідно шифру
step 3 до шифру додати ключі для читання шифру
//step 4 додати масив хочаб з одного алфавіту
//step 5 кодувати спец символи
// step 6 створити взаємодію з користувачем на введеня тексту
//step 7  зіброати все докупи щоб працювало.

what should be done in advance in app:
- vocabulary: abcd..xyz012345679{symbolsArray}



java -jar MyApp.jar -f c://file.txt

original: hello world
encrypted(+1): ifmmp xpsme
