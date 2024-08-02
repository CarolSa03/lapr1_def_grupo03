# Read Me

---

#### *Project Objective*

The aim is to develop an application in Java (Horstmann, 2015) as a group project, applying concepts from the field of mathematics. We also intend to create a report that describes the designed application, the development process, and presents and critiques the obtained results.

#### *Work Plan*

We will need to implement an application that allows studying and evaluating the spread of fake news under certain conditions. This application should include a set of modules that allow: reading and writing data from files; implementing the Euler and 4th order Runge-Kutta methods; implementing, visualizing, and evaluating the fake news spread model (given the initial state), using the aforementioned methods.

---

## ***Model***

The SIR model for population biology of infectious diseases was originally developed by Kermack and McKendrick in 1927 (Kermack, 1991). This model describes the interaction (dynamics) of three populations of individuals.

#### *Assumptions*

In this model, it is assumed that the news spreading in a given population N is fake and that, as in the SIR model, there are three possible populations, S, I, and R:

**S (susceptibles)** - in this phase, the individual is exposed to the fake news and can be influenced (they haven't heard the fake news yet).  
**I (infected)** - phase where the individual spreads the fake news to susceptibles through contact (they have heard the fake news and believe it).  
**R (recovered)** - phase where the individual no longer believes the fake news (they have heard the fake news and do not believe it).

**β (beta)** - rate of spread, or contagion, of the population.  
**ρ (rho)** - rate of the population immune to the fake news upon hearing it.  
**γ (gamma)** - rate at which an infected individual rejects the fake news.  
**α (alpha)** - rate at which the population is re-infected.

Fake news spreads through direct interaction with the infected, and there is a **fixed** number of people in the system:
**N = S + I + R**.

#### *Initial Conditions*

**The system of ODEs has a set of initial conditions that need to be known:**

The **N** size of the population (e.g., the number of DEI students).  
The spread of fake news is initiated by 1 person (**consider S = N - 1, I = 1, R = 0**).  
The **number of days** for the model forecast.  
The model parameters: **α, β, γ, and ρ**.

#### *Comparative Analysis*

A comparative analysis of the results obtained by numerical methods for certain values of 0 < h ≤ 1 should be performed. The application should also include a set of functionalities that **allow a comparative analysis of the results obtained for different time intervals (number of days)**.  
The application should include two functionalities that allow:

**Comparing the results obtained, for a given set of parameters, population size N, and number of days, by the numerical methods used.  
Comparing the behavior of the SIR model when considering different sets of model parameters (α, β, γ, and ρ).**

**The results should be saved in a table, in a text file, containing 4 columns with the corresponding values: day, S, I, R, and N**.