mport sqlite3
con = sqlite3.connect('example.db')



cur = con.cursor()



# Create table
cur.execute('''CREATE TABLE word
(headword text, definaton text)''')

'''
{
"vocabulary": "the body of words used in a particular language.",
"sentence": "a set of words that is complete in itself",
"context": "the circumstances that form the setting for an event"
}
'''


# Insert a row of data
cur.execute("INSERT INTO word VALUES ('vocabulary','the body of words used in a particular language',\
    'sentence', 'a set of words )")



# Save (commit) the changes
con.commit()



# We can also close the connection if we are done with it.
# Just be sure any changes have been committed or they will be lost.
con.close()