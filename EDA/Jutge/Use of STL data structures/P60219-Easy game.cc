#include <iostream>
#include <set>
using namespace std;
 
 
struct strsize {
	bool operator() (const string& a, const string& b) const {
		if (a.size() < b.size()) return true;
		else if (a.size() > b.size()) return false;
		else return a < b;
	}
};
 
int main() {
	int count = 1;
	string w;
	set<string>::iterator it1;
	set<string, strsize>::iterator it2;
	
	while (w != "QUIT") {
		set<string> has;
		set<string,strsize> had;
		while (cin >> w and w != "END" and w != "QUIT") {
			it1 = has.find(w);
			if (it1 == has.end()) {
				has.insert(it1,w);
				it2 = had.find(w);
				if (it2 != had.end()) had.erase(it2);
			}
			else {
				it2 = had.begin();
				had.insert(it2,*it1);
				has.erase(it1);
			}
		}
		if (count > 1) cout << endl;
		cout << "GAME #" << count << endl << "HAS:" << endl;
		for (it1 = has.begin(); it1 != has.end(); ++it1) 
			cout << *it1 << endl;
		cout << endl << "HAD:" << endl;
		for (it2 = had.begin(); it2 != had.end(); ++it2) 
			cout << *it2 << endl;
		++count;
	}
}
