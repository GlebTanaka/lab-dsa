from linked_list import LinkedList


class TestLinkedListInit:
    def test_init_with_value(self):
        ll = LinkedList(1)
        assert ll.head.value == 1
        assert ll.tail.value == 1
        assert ll.length == 1

    def test_init_empty(self):
        ll = LinkedList()
        assert ll.head is None
        assert ll.tail is None
        assert ll.length == 0


class TestAppend:
    def test_append_to_empty(self):
        ll = LinkedList()
        ll.append(1)
        assert ll.head.value == 1
        assert ll.tail.value == 1
        assert ll.length == 1

    def test_append_multiple(self):
        ll = LinkedList(1)
        ll.append(2)
        ll.append(3)
        assert str(ll) == "1 -> 2 -> 3 -> None"
        assert ll.length == 3
        assert ll.tail.value == 3


class TestPrepend:
    def test_prepend_to_empty(self):
        ll = LinkedList()
        ll.prepend(1)
        assert ll.head.value == 1
        assert ll.tail.value == 1
        assert ll.length == 1

    def test_prepend_multiple(self):
        ll = LinkedList(3)
        ll.prepend(2)
        ll.prepend(1)
        assert str(ll) == "1 -> 2 -> 3 -> None"
        assert ll.head.value == 1


class TestGetAtIndex:
    def test_get_valid(self):
        ll = LinkedList(1)
        ll.append(2)
        ll.append(3)
        assert ll.get_at_index(0).value == 1
        assert ll.get_at_index(1).value == 2
        assert ll.get_at_index(2).value == 3

    def test_get_out_of_bounds(self):
        ll = LinkedList(1)
        assert ll.get_at_index(-1) is None
        assert ll.get_at_index(1) is None


class TestSetAtIndex:
    def test_set_valid(self):
        ll = LinkedList(1)
        ll.append(2)
        assert ll.set_at_index(1, 99) is True
        assert ll.get_at_index(1).value == 99

    def test_set_invalid(self):
        ll = LinkedList(1)
        assert ll.set_at_index(5, 99) is False


class TestInsert:
    def test_insert_at_beginning(self):
        ll = LinkedList(2)
        ll.insert(0, 1)
        assert str(ll) == "1 -> 2 -> None"

    def test_insert_at_end(self):
        ll = LinkedList(1)
        ll.insert(1, 2)
        assert str(ll) == "1 -> 2 -> None"
        assert ll.tail.value == 2

    def test_insert_in_middle(self):
        ll = LinkedList(1)
        ll.append(3)
        ll.insert(1, 2)
        assert str(ll) == "1 -> 2 -> 3 -> None"
        assert ll.length == 3

    def test_insert_out_of_bounds(self):
        ll = LinkedList(1)
        assert ll.insert(-1, 0) is False
        assert ll.insert(5, 0) is False


class TestRemove:
    def test_remove_first(self):
        ll = LinkedList(1)
        ll.append(2)
        removed = ll.remove_first()
        assert removed.value == 1
        assert ll.head.value == 2
        assert ll.length == 1

    def test_remove_first_single(self):
        ll = LinkedList(1)
        removed = ll.remove_first()
        assert removed.value == 1
        assert ll.head is None
        assert ll.tail is None
        assert ll.length == 0

    def test_remove_first_empty(self):
        ll = LinkedList()
        assert ll.remove_first() is None

    def test_remove_last(self):
        ll = LinkedList(1)
        ll.append(2)
        removed = ll.remove_last()
        assert removed.value == 2
        assert ll.tail.value == 1
        assert ll.length == 1

    def test_remove_last_single(self):
        ll = LinkedList(1)
        removed = ll.remove_last()
        assert removed.value == 1
        assert ll.head is None
        assert ll.tail is None
        assert ll.length == 0

    def test_remove_last_empty(self):
        ll = LinkedList()
        assert ll.remove_last() is None

    def test_remove_at_index_middle(self):
        ll = LinkedList(1)
        ll.append(2)
        ll.append(3)
        removed = ll.remove_at_index(1)
        assert removed.value == 2
        assert str(ll) == "1 -> 3 -> None"
        assert ll.length == 2

    def test_remove_at_index_invalid(self):
        ll = LinkedList(1)
        assert ll.remove_at_index(-1) is None
        assert ll.remove_at_index(1) is None


class TestReverse:
    def test_reverse(self):
        ll = LinkedList(1)
        ll.append(2)
        ll.append(3)
        ll.reverse()
        assert str(ll) == "3 -> 2 -> 1 -> None"
        assert ll.head.value == 3
        assert ll.tail.value == 1

    def test_reverse_single(self):
        ll = LinkedList(1)
        ll.reverse()
        assert str(ll) == "1 -> None"

    def test_reverse_empty(self):
        ll = LinkedList()
        ll.reverse()
        assert str(ll) == "None"


class TestStr:
    def test_str(self):
        ll = LinkedList(1)
        ll.append(2)
        assert str(ll) == "1 -> 2 -> None"

    def test_str_empty(self):
        ll = LinkedList()
        assert str(ll) == "None"
