This repo contains datastructures and algorithms practise files.

Q) Please explain polynomial rolling hash

Absolutely! Let’s walk through what Polynomial Rolling Hash is, how it works, and why it’s useful for substring matching, especially in problems like “Repeated DNA Sequences.”

⸻

🔍 What is a Polynomial Rolling Hash?

A Polynomial Rolling Hash is a hashing technique used to efficiently compute hash values of substrings in a way that:
•	Is fast
•	Avoids collisions (to a good extent)
•	Allows rolling: i.e., compute the hash of s[i+1..j+1] from s[i..j] in constant time

⸻

💡 Hash Formula

For a string s = s[0..k-1] of length k, we treat it like a base-p number:

\text{Hash}(s) = s[0] \cdot p^{k-1} + s[1] \cdot p^{k-2} + \ldots + s[k-1] \cdot p^0 \mod M
•	p: a small prime number (e.g. 31 or 101)
•	M: a large prime number (to avoid overflow)
•	s[i]: numeric value of the i-th character (e.g., 'A' → 1, 'C' → 2, etc.)

This behaves like how numbers work in positional notation (e.g. base-10: 342 = 3×100 + 4×10 + 2×1).

⸻

✅ Example

Let’s hash "ACGT" with:
•	A=1, C=2, G=3, T=4
•	Base p = 101
•	No mod for now (to keep it simple)

\text{Hash}(“ACGT”) = 1×101^3 + 2×101^2 + 3×101^1 + 4×101^0
= 1×1030301 + 2×10201 + 3×101 + 4
= 1030301 + 20402 + 303 + 4 = 1055010

⸻

🔁 Rolling Hash Mechanism

Suppose you’ve already computed the hash of "ACGT" → hash1.

Now you want the hash of "CGTA" (slide window by 1 character).

Step-by-step:
1.	Remove the contribution of the first character ('A').
2.	Multiply the remaining hash by p (shift positions).
3.	Add the new character’s contribution ('A' at end).

Formula:

\text{NewHash} = ((\text{OldHash} - s[i] \cdot p^{k-1}) \cdot p + s[i+k]) \mod M

This lets you slide the window in O(1) time.

⸻

💎 Benefits

Feature	Why it matters
Rolling (sliding window)	Avoids recomputing hash from scratch
Fast substring comparison	O(1) for comparing large substrings
Low collision rate	Especially with large M, prime p
Space efficient	Only track current hash + powers of p


⸻

🔐 Why Modulo?
•	To keep numbers within integer limits.
•	To ensure unique-ish mapping: two different substrings rarely collide when mod is a large prime (e.g. 1_000_000_007).

⸻

🔧 Summary of Parameters

Parameter	Value (Common)	Purpose
p	31, 101	Prime base for polynomial
M	1e9 + 7	Modulus to reduce collision/overflow
s[i]	1–26, or 1–4	Integer mapping of characters


⸻

🔁 Summary in Your Context (DNA Strings)
•	DNA has 4 characters, so map as: A=1, C=2, G=3, T=4
•	For a 10-letter substring, compute its polynomial hash
•	Slide the window using rolling hash
•	Store hashes in a set to find repeats

⸻

Would you like a visual walkthrough with an example of 2–3 windows being rolled over to show how the hash updates?