# -*- coding: utf-8 -*-

""":mod:`listiterator` module : list implementation with iterator interaction

Provides constructor, selectors and modifiers for mutable lists.
Lists of this module must be traversed via iterators.

An iterator for lists allows the programmer to traverse the list in
either direction and adding elements to the list during iteration.

An iterator has no current element; its cursor position always lies
between the element that would be returned by a call to :code:`previous` and
the element that would be returned by a call to `next`.

An iterator for a list of length n has n+1 possible cursor positions,
as illustrated by the carets (^) below:

.. code::

                      Element(0)   Element(1)   Element(2)   ... Element(n-1)
 cursor positions:  ^            ^            ^            ^                  ^

:author: `FIL - IEEA - Univ. Lille1.fr <http://portail.fil.univ-lille1.fr>`_

:date: 2016, january

"""

class EmptyList (Exception):
    """
    Exception for empty lists
    """
    def __init__ (self,msg):
        self.message = msg

class NoSuchElementException (Exception):
    """
    Exception for iterators not positionned
    """
    def __init__ (self,msg):
        self.message = msg

def __new_cell (v,next_cell,prev_cell):
    return { "value" : v, "next" : next_cell, "prev" : prev_cell }

def __empty_cell (c):
    return c == None

def empty_list ():
    """
    Creates a new empty list.

    :return: A frest list
    :rtype: dict
    """
    return { "head" : None, "tail" : None }

def is_empty (l):
    """
    Returns true if the list is empty, false else.

    :param l: The list
    :type l: dict
    :rtype: boolean
    """
    return l == { "head" : None, "tail" : None }

def cons (l,v):
    """
    Add the value :code:`v` at the begining of the list :code:`l`.

    :param l: The list, possibly empty.
    :type l: dict
    :param v: The value to be added.
    :type v: Any

    UC: not compatible with iterators
    """
    if l["head"] == None:
        l["head"] = l["tail"] = __new_cell (v, None, None)
    else:
        l["head"] = __new_cell (v, l["head"], None)
        l["head"]["next"]["prev"] = l["head"]

def __print_without_iterator_forward (c):
    """
    :param c: A cell
    :type c: dict
    """
    if __empty_cell(c):
        print()
    else:
        print(c["value"],end=' ')
        __print_without_iterator_forward (c["next"])

def __print_without_iterator_reversed (c):
    """
    :param c: A cell
    :type c: dict
    """
    if __empty_cell(c):
        print()
    else:
        print(c["value"], end=' ')
        __print_without_iterator_reversed(c["prev"])

def print_list (l,reverse=False):
    """
    :param l: The list, possibly empty.
    :type l: dict
    :param reverse: True if the the list *l* must be printed from the end to the begining
    :type reverse: boolean
    """
    if is_empty(l):
        raise EmptyList("The list has no elements")
    if reverse:
        __print_without_iterator_reversed (l["tail"])
    else:
        __print_without_iterator_forward (l["head"])


def get_listiterator (l, from_the_end = False):
    """
    Creates a new iterator for list *l*.

    :param l: The list
    :type l: dict
    :return: An iterator at the begining of the list
    :rtype: dict
    """
    if from_the_end:
        return {"predecessor" : l['tail'], "successor": None, 'list':l}
    else:
        return {"predecessor" : None, "successor": l['head'], 'list':l}


def hasNext (it):
    """
    Returns :code:`True` if this list iterator has more elements when
    traversing the list in the forward direction. (In other words,
    returns :code:`True` if :code:`next(it)` would return an element rather than
    throwing an exception.)

    :param it: The iterator
    :type it: dict
    :rtype: boolean
    """
    return not __empty_cell(it["successor"])


def next (it):
    """
    Returns the next element in the list and advances the cursor
    position. This method may be called repeatedly to iterate through
    the list, or intermixed with calls to :code:`previous(it)` to go back and
    forth. (Note that alternating calls to next and previous will
    return the same element repeatedly.)

    Throws NoSuchElementException if theere is no such element.

    :param it: The iterator
    :type it: dict
    :rtype: Type of the elements of the list
    """
    if hasNext(it):
        it["predecessor"] = it["successor"]
        it["successor"] = it["successor"]["next"]
        return it["predecessor"]
    else:
        raise NoSuchElementException("The iterator has no next")


def hasPrevious (it):
    """
    Returns :code:`True` if this list iterator has more elements when
    traversing the list in the reverse direction. (In other words,
    returns :code:`True` if :code:`previous(it)` would return an
    element rather than throwing an exception.)

    :param it: The iterator
    :type it: dict
    :rtype: boolean
    """
    return not __empty_cell(it["predecessor"])


def previous (it):
    """
    Returns the previous element in the list and moves the cursor
    position backwards. This method may be called repeatedly to
    iterate through the list backwards, or intermixed with calls to
    :code:`next(it)` to go back and forth. (Note that alternating calls to next
    and previous will return the same element repeatedly.)

    Throws NoSuchElementException if there is no such element.

    :param it: The iterator
    :type it: dict
    :rtype: Type of the elements of the list
    """
    if hasPrevious(it):
        it["successor"] = it["predecessor"]
        it["predecessor"] = it["predecessor"]["prev"]
        return it["successor"]
    else:
        raise NoSuchElementException("The iterator has no previous element")


def add (it,v):
    """Inserts the specified element into the list. The element is
    inserted immediately before the element that would be returned by
    next(), if any, and after the element that would be returned by
    previous(), if any. (If the list contains no elements, the new
    element becomes the sole element on the list.) The new element is
    inserted before the implicit cursor: a subsequent call to next
    would be unaffected, and a subsequent call to previous would
    return the new element.

    :param it: The iterator
    :type it: dict
    :param v: The element
    :type v: Any
    """
    # Empty list
    if not hasNext(it) and not hasPrevious(it):
        new_cell = __new_cell(v, None, None)
        it["successor"] = new_cell
        it['list']['head'], it['list']['tail'] = new_cell, new_cell
    # Tail of the list
    elif not hasNext(it):
        prev_cell = it["predecessor"]
        new_cell = __new_cell(v, None, prev_cell)
        prev_cell["next"] = new_cell
        it["predecessor"] = new_cell
        it["list"]["tail"] = new_cell
    # Head of the list
    elif not hasPrevious(it):
        next_cell = it["successor"]
        new_cell = __new_cell(v, next_cell, None)
        next_cell["prev"] = new_cell
        it["predecessor"] = new_cell
        it["list"]["head"] = new_cell
    # Usual case
    else:
        next_cell = it["successor"]
        prev_cell = it["predecessor"]
        new_cell = __new_cell(v, next_cell, prev_cell)
        next_cell["prev"] = new_cell
        prev_cell["next"] = new_cell
        it["predecessor"] = new_cell

def remove(it):
    '''Removes the element the element that corresponds to the predecessor value of the iterator
    meaning that if a iterator is created at the start of a given list, if remove is called at
    that moment it should raise a NoSuchElement exception. A `normal` (meaning the iterator has
    a previous and next element) usage of the remove function deletes the predecessor element and
    replaces it with the previous of the predecessor element, meaning that if someone wishes to
    delete the entire list, it would be enough to place the iterator at the end of the list and call
    the remove function n times (n being the length of the list).

    :param it: The iterator
    :type it: dict
    '''
    # No element before the current one 
    if not hasPrevious(it):
        raise NoSuchElementException('Cannot remove that element')
    elif it['predecessor'] == it['list']['head']:
        it['successor']['prev'] = None
        it['list']['head'] = it['successor']
        it['predecessor'] = None
    # Tail of the list
    elif not hasNext(it):
        it['predecessor'] = it['predecessor']['prev']
        it['list']['tail'] = it['predecessor']
        it['predecessor']['next'] = None
    # Usual case
    else:
        it['successor']['prev'] = it['predecessor']['prev']
        it['predecessor'] = it['predecessor']['prev']
        it['predecessor']['next'] = it['successor']
