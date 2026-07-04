class Node:
    def __init__(self, value):
        self.value = value
        self.next = None


class LinkedList:
    def __init__(self, value=None):
        if value is not None:
            new_node = Node(value)
            self.head = new_node
            self.tail = new_node
            self.length = 1
        else:
            self.head = None
            self.tail = None
            self.length = 0

    def append(self, value):
        new_node = Node(value)
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node
        self.length += 1

    def prepend(self, value):
        new_node = Node(value)
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.next = self.head
            self.head = new_node
        self.length += 1

    def get_at_index(self, index):
        if index < 0 or index >= self.length:
            return None
        current = self.head
        for _ in range(index):
            current = current.next
        return current

    def set_at_index(self, index, value):
        node = self.get_at_index(index)
        if node is None:
            return False
        node.value = value
        return True

    def insert(self, index, value):
        if index < 0 or index > self.length:
            return False
        if index == 0:
            self.prepend(value)
            return True
        if index == self.length:
            self.append(value)
            return True
        new_node = Node(value)
        prev = self.get_at_index(index - 1)
        new_node.next = prev.next
        prev.next = new_node
        self.length += 1
        return True

    def remove_first(self):
        if self.head is None:
            return None
        removed = self.head
        if self.head == self.tail:
            self.head = None
            self.tail = None
        else:
            self.head = self.head.next
        removed.next = None
        self.length -= 1
        return removed

    def remove_last(self):
        if self.head is None:
            return None
        if self.head == self.tail:
            removed = self.head
            self.head = None
            self.tail = None
            self.length -= 1
            return removed
        current = self.head
        while current.next != self.tail:
            current = current.next
        removed = self.tail
        self.tail = current
        self.tail.next = None
        self.length -= 1
        return removed

    def remove_at_index(self, index):
        if index < 0 or index >= self.length:
            return None
        if index == 0:
            return self.remove_first()
        if index == self.length - 1:
            return self.remove_last()
        prev = self.get_at_index(index - 1)
        removed = prev.next
        prev.next = removed.next
        removed.next = None
        self.length -= 1
        return removed

    def reverse(self):
        prev = None
        current = self.head
        while current is not None:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        self.tail = self.head
        self.head = prev

    def __str__(self):
        values = []
        current = self.head
        while current is not None:
            values.append(str(current.value))
            current = current.next
        values.append("None")
        return " -> ".join(values)
