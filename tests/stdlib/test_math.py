import unittest

from ..utils import TranspileTestCase

class MathModuleTests(TranspileTestCase):
    def test_trunc1(self):
        self.assertCodeExecution("""
            from math import trunc
            x = 3.1
            y = 0.9
            print(trunc(x))
            print(trunc(y))
        """)

    def test_trunc2(self):
        self.assertCodeExecution("""
            from math import trunc
            x = -1.1
            y = -0.9999999999999999999999999999999999
            print(trunc(x))
            print(trunc(y))
        """)
