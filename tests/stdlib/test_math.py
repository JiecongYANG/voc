from unittest import expectedFailure

from .. utils import TranspileTestCase

class MathModuleTests(TranspileTestCase):
    def test_trunc1(self):
        self.assertCodeExecution("""
            import math
            x = 3.1
            y = 0.9
            z = -1.1
            w = -0.9999999999999999999999999999999999
            print(math.trunc(x))
            print(math.trunc(y))
            print(math.trunc(z))
            print(math.trunc(w))
        """)

    @expectedFailure
    def test_trunc2(self):
        self.assertCodeExecution("""
            import math
            print(math.trunc('not a number'))
        """)

    @expectedFailure
    def test_trunc3(self):
        self.assertCodeExecution("""
            import math
            print(math.trunc(['not', 'a', 'number']))
        """)
