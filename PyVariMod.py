# python test script for passing variables
import sys

def variableapasser():
    if len(sys.argv) == 4: # Checking if 3 arguments are passed (sys.argv[0] is the script name itself)
        # AHHHHH I FIGURED OUT THE LIBRARY THING
        mass = float(sys.argv[1])
        drag = float(sys.argv[2])
        diameter = float(sys.argv[3])
        # test values for variable passing check{
        print(f"Mass: {mass}")
        print(f"Drag: {drag}")
        print(f"Diameter: {diameter}")
        # }
    else:
        print("Expected 3 arguments: mass, drag, and diameter.")
        return mass, drag, diameter
variableapasser()