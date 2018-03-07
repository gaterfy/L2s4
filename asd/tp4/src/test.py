# -*- coding: utf-8 -*-

""":mod:`test` module : Test module for bloomfilter analysis

:author: `FIL - IEEA - Univ. Lille1.fr <http://portail.fil.univ-lille1.fr>`_

:date: 2016, january

"""
import random
import bloomfilter

nb_hash_functions = 8
random_tab = [ 0 for i in range(128 * nb_hash_functions)]

def init_random_tab ():
    """
    Creates the hash functions.
    """
    global random_tab
    for i in range(128):
        for j in range(nb_hash_functions):
            random_tab[j * 128 + i] = random.randint(1,32000)

def code_of_string (str,n):
    """
    For a given string, returns the hash code for the n-th hashing function.

    :param str: The string to be hashed.
    :type str: string
    :param n: The function number.
    :type n: int
    :return: A hash code
    :rtype: int

    .. note::
       1 <= n <= nb_hash_functions
    """
    return sum([random_tab[(128*n)+ord(char)] for char in str])

def random_word ():
    """
    Returns a word with random letters whose length is between 4 and 7.

    :rtype: string
    """
    letters = [ chr(i) for i in range(ord('a'),ord('z')+1) ] + [ chr(i) for i in range(ord('A'),ord('Z')+1) ]
    length = 4 + random.randint(0,4)
    str = ""
    for i in range(length):
        str = str + random.choice(letters)
    return str

def analyse_test ():
    random_words = [random_word() for _ in range(2**10)]
    counter_words = 0
    counter_errors = 0
    for n in range(1, 9):
        for t in range(10, 21):
            counter_words = 0
            counter_errors = 0
            bf = bloomfilter.create(t, code_of_string, n)
            for word in random_words:
                bloomfilter.add(bf, word)
            for k in range(2**14):
                w = random_word()
                if w not in random_words:
                    counter_words += 1
                    if bloomfilter.contains(bf, w):
                        counter_errors += 1
            print("{} {} {} {} {}".format(t, n, counter_words, counter_errors, counter_errors/counter_words))
        print('\n')

if __name__ == "__main__":
    init_random_tab()
#    bf = bloomfilter.create(2,code_of_string,8)
#    w = random_word()
#    bloomfilter.add(bf,"timoleon")
#    if bloomfilter.contains(bf,"timoleon"):
#        print("%s est present" % ("timoleon"))
#    if bloomfilter.contains(bf,w):
#        print("%s est present" % (w))
    analyse_test()
