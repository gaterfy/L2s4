<!--
header.php

authors : Thomas Lombart - Martin Vasilev

Contains the header (navbar) that allows the user to navigate in the app even when being on other pages
-->

<nav>
    <h1><a href="index.php"><i class="fa fa-home" aria-hidden="true"></i> Rezozio</a></h1>
    <div id="account">
    <?php
    if (isset($_SESSION['ident'])) {
      echo "<a href='settings.php' class='settings'><i class='fa fa-cog' aria-hidden='true'></i> Settings</a>";
      echo "<a href='profile.php'><i class='fa fa-user' aria-hidden='true'></i> My profile</a>";
      echo "<a id='logout'><i class='fa fa-sign-out' aria-hidden='true'></i> Signout</a>";
    } else {
      echo "<a href='signin.php'>Sign in <i class='fa fa-sign-in' aria-hidden='true'></i></a>";
      echo "<a href='signup.php' id='signout'>Sign up <i class='fa fa-user-plus' aria-hidden='true'></i></a>";
    }
    ?>
    </div>
</nav>
<!-- We handle the signout functionality from the header -->
<script src="js/account/signout.js" charset="utf-8"></script>
