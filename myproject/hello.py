'''
Description: 0810
Author: Yixin Li
Date: 2022-02-24 08:40:54
LastEditors: Yixin Li
LastEditTime: 2022-02-24 17:47:56
'''
from flask import Flask
from flask import session
from flask import request
from flask import redirect
from flask import url_for

app = Flask(__name__)

# Set the secret key to some random bytes. Keep this really secret!
app.secret_key = b'_5#y2L"F4Q8z\n\xec]/'

@app.route('/hello')
def hello():
    return 'Hello, World'

@app.route('/')
def index():
    if 'username' in session:
        return f'Logged in as {session["username"]}'
    return 'You are not logged in'

@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        session['username'] = request.form['username']
        return redirect(url_for('index'))
    return '''
    <style>
        .center {
            position: fixed;
            top: 50%;
            left: 50%;
            width:50%;
            height: 50%;
            -webkit-transform: translateX(-50%) translateY(-50%);
        }
    </style>
        
        <div class="center">
                <center>
                <h1>Login</h1>
                <form method="post">
                    <p>username <input type=text name=username placeholder=username required=required>
                    <p>password <input type=password name=password placeholder=password required=required>
                    <p><input type=submit value=Login>
                </form>
        </div>
    '''

@app.route('/logout')
def logout():
    # remove the username from the session if it's there
    session.pop('username', None)
    return redirect(url_for('index'))